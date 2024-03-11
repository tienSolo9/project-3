package com.javaweb.service;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;

import java.util.List;

public interface IBuildingService {
    ResponseDTO Staffs(Long buildingId);
    List<BuildingSearchResponse> findAllBuilding(BuildingSearchRequest buildingSearchRequest);

    List<BuildingEntity> getBuildingByIds(List<Long> ids);
    List<RentAreaEntity> getRentAreasById(Long id);
}
