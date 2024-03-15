package com.javaweb.service;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;

import java.util.List;

public interface IBuildingService {
    ResponseDTO Staffs(Long buildingId);
    List<BuildingSearchResponse> findAllBuilding(BuildingDTO buildingDTO);

    void saveAllRentAreas(String rentArea, BuildingEntity buildingEntity);
    void saveThumbnail(BuildingDTO buildingDTO, BuildingEntity buildingEntity);
}
