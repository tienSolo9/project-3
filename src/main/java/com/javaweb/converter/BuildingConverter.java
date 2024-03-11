package com.javaweb.converter;

import com.javaweb.entity.RentAreaEntity;
import com.javaweb.enums.districtCode;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.IRentAreaEntityRepository;
import com.javaweb.utils.StringUtils;
import org.modelmapper.ModelMapper;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.response.BuildingSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class BuildingConverter {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    IRentAreaEntityRepository iRentAreaEntityRepository;

    public BuildingSearchResponse toBuildingResponse(BuildingEntity buildingEntity) {
        BuildingSearchResponse result = modelMapper.map(buildingEntity, BuildingSearchResponse.class);

        Map<String, String> district = districtCode.type();
        if (buildingEntity.getDistrict() != null) {
            result.setAddress(buildingEntity.getStreet() + ", " + buildingEntity.getWard() + ", " + district.get(buildingEntity.getDistrict()));
        }
        List<RentAreaEntity> rentAreas = buildingEntity.getRentAreaEntities();
        String rentareaResult = rentAreas.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
        result.setRentArea(rentareaResult);
        return result;
    }

    public BuildingSearchRequest toBuildingRequest(BuildingEntity buildingEntity) {
        BuildingSearchRequest buildingSearchRequest = modelMapper.map(buildingEntity, BuildingSearchRequest.class);

        String typeCode = buildingEntity.getTypeCode();
        if (StringUtils.check(typeCode)) {
            List<String> typeCodes = new ArrayList<>();
            String[] str = typeCode.split(",");
            for (String it : str) {
                typeCodes.add(it);
            }
            buildingSearchRequest.setTypeCode(typeCodes);
        }

        List<RentAreaEntity> rentAreas = buildingEntity.getRentAreaEntities();
        String rentArea = rentAreas.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
        buildingSearchRequest.setRentArea(rentArea);
        return buildingSearchRequest;
    }

    public BuildingEntity toBuildingEntity(BuildingSearchRequest buildingSearchRequest) {
        BuildingEntity buildingEntity = modelMapper.map(buildingSearchRequest, BuildingEntity.class);
        List<String> types = buildingSearchRequest.getTypeCode();
        String typeCode = types.stream().map(it -> it.toString()).collect(Collectors.joining(","));
        buildingEntity.setTypeCode(typeCode);

        String rentArea = buildingSearchRequest.getRentArea();
        String[] str = rentArea.split(",");
        List<RentAreaEntity> ExistRentAreas = iRentAreaEntityRepository.findRentAreaEntitiesByBuildingEntity_id(buildingEntity.getId());
        for (RentAreaEntity it : ExistRentAreas) {
            entityManager.remove(it);
        }

        for (String item : str) {
            if(StringUtils.check(item)){
                RentAreaEntity it = new RentAreaEntity();
                it.setValue(Integer.parseInt(item));
                it.setBuildingEntity(buildingEntity);
                entityManager.merge(it);
            }
        }


        return buildingEntity;
    }
}
