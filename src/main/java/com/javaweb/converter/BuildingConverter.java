package com.javaweb.converter;

import com.javaweb.entity.RentAreaEntity;
import com.javaweb.enums.districtCode;
import com.javaweb.model.dto.BuildingDTO;
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

    public BuildingDTO toBuildingDTO(BuildingEntity buildingEntity) {
        BuildingDTO buildingDTO = modelMapper.map(buildingEntity, BuildingDTO.class);

        String typeCode = buildingEntity.getTypeCode();
        if (StringUtils.check(typeCode)) {
            List<String> typeCodes = new ArrayList<>();
            String[] str = typeCode.split(",");
            for (String it : str) {
                typeCodes.add(it);
            }
            buildingDTO.setTypeCode(typeCodes);
        }

        List<RentAreaEntity> rentAreas = buildingEntity.getRentAreaEntities();
        String rentArea = rentAreas.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
        buildingDTO.setRentArea(rentArea);
        return buildingDTO;
    }

    public BuildingEntity toBuildingEntity(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);
        List<String> types = buildingDTO.getTypeCode();
        String typeCode = types.stream().map(it -> it.toString()).collect(Collectors.joining(","));
        buildingEntity.setTypeCode(typeCode);


        return buildingEntity;
    }
}
