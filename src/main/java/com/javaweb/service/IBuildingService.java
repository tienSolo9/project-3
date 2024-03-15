package com.javaweb.service;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBuildingService {
    ResponseDTO Staffs(Long buildingId);
    List<BuildingSearchResponse> findAllBuilding(BuildingDTO buildingDTO, Pageable pageable);

    void saveAllRentAreas(String rentArea, BuildingEntity buildingEntity);
    void saveThumbnail(BuildingDTO buildingDTO, BuildingEntity buildingEntity);
}
