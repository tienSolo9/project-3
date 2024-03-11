package com.javaweb.service.impl;

import com.javaweb.converter.BuildingConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.IRentAreaEntityRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.repository.IBuildingRepository;
import com.javaweb.repository.custom.IBuildingRepositoryCustom;
import com.javaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingServiceImpl implements IBuildingService {
    @Autowired
    IBuildingRepository iBuildingRepository;

    @Autowired
    IBuildingRepositoryCustom iBuildingRepositoryCustom;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BuildingConverter buildingConverter;

    @Autowired
    IRentAreaEntityRepository iRentAreaEntityRepository;
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
    public List<BuildingSearchResponse> findAllBuilding(BuildingSearchRequest buildingSearchRequest) {
        List<BuildingEntity> ListBuilding = iBuildingRepositoryCustom.getAllBuildings(buildingSearchRequest);
        List<BuildingSearchResponse> result = new ArrayList<>();

        for(BuildingEntity item : ListBuilding){
            BuildingSearchResponse component = buildingConverter.toBuildingResponse(item);
            result.add(component);
        }
        return result;
    }

    @Override
    public List<BuildingEntity> getBuildingByIds(List<Long> ids) {
        List<BuildingEntity> result = new ArrayList<>();
        for(Long item : ids){
            BuildingEntity buildingEntity = iBuildingRepository.findById(item).get();
            result.add(buildingEntity);
        }
        return result;
    }

    @Override
    public List<RentAreaEntity> getRentAreasById(Long id) {
        List<RentAreaEntity> result = iRentAreaEntityRepository.findRentAreaEntitiesByBuildingEntity_id(id);
        return result;
    }


}
