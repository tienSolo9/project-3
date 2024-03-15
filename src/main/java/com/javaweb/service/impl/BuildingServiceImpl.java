package com.javaweb.service.impl;

import com.javaweb.converter.BuildingConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.IRentAreaEntityRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.repository.IBuildingRepository;
import com.javaweb.repository.custom.IBuildingRepositoryCustom;
import com.javaweb.service.IBuildingService;
import com.javaweb.utils.StringUtils;
import com.javaweb.utils.UploadFileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingServiceImpl implements IBuildingService {
    @Autowired
    IBuildingRepository iBuildingRepository;
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    IBuildingRepositoryCustom iBuildingRepositoryCustom;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BuildingConverter buildingConverter;

    @Autowired
    IRentAreaEntityRepository iRentAreaEntityRepository;

    private final UploadFileUtils uploadFileUtils = new UploadFileUtils();
    @Override
    public void saveThumbnail(BuildingDTO buildingDTO, BuildingEntity buildingEntity) {
        String path = "/building/" + buildingDTO.getImageName();
        if (null != buildingDTO.getImageBase64()) {
            if (null != buildingEntity.getImage()) {
                if (!path.equals(buildingEntity.getImage())) {
                    File file = new File("D://office" + buildingEntity.getImage());
                    file.delete();
                }
            }
            String base64Code = buildingDTO.getImageBase64();
            String isBase64 = base64Code.substring(base64Code.indexOf(",") + 1);
            byte[] bytes = Base64.decodeBase64(isBase64.getBytes());
            uploadFileUtils.writeOrUpdate(path, bytes);
            buildingEntity.setImage(path);
        }
    }
    @Override
    public ResponseDTO Staffs(Long buildingId) {
        BuildingEntity buildingEntity = iBuildingRepository.findById(buildingId).get();
        List<UserEntity> staffs = userRepository.findByStatusAndRoles_code(1,"STAFF");
        List<UserEntity> staffsInCharge = buildingEntity.getUserEntities();

        ResponseDTO result = new ResponseDTO();
        List<StaffResponseDTO> ListSt = new ArrayList<>();
        for(UserEntity it: staffs){
            StaffResponseDTO item = new StaffResponseDTO();
            item.setStaffId(it.getId());
            item.setFullName(it.getFullName());

            if(staffsInCharge.contains(it)){
                item.setChecked("checked");
            }
            else{
                item.setChecked("");
            }
            ListSt.add(item);
        }

        result.setData(ListSt);
        result.setMessage("success");
        return result;
    }


    @Override
    public List<BuildingSearchResponse> findAllBuilding(BuildingDTO buildingDTO, Pageable pageable) {
        Page<BuildingEntity> buildings = iBuildingRepositoryCustom.getAllBuildings(buildingDTO, pageable);
        List<BuildingEntity> ListBuilding = buildings.getContent();
        List<BuildingSearchResponse> result = new ArrayList<>();

        for(BuildingEntity item : ListBuilding){
            BuildingSearchResponse component = buildingConverter.toBuildingResponse(item);
            result.add(component);
        }
        return result;
    }

    @Override
    public void saveAllRentAreas(String rentArea, BuildingEntity buildingEntity) {
        String[] str = rentArea.split(",");
        for (String item : str) {
            if (StringUtils.check(item)) {
                RentAreaEntity it = new RentAreaEntity();
                it.setValue(Integer.parseInt(item));
                it.setBuildingEntity(buildingEntity);
                entityManager.merge(it);
            }
        }
    }



}
