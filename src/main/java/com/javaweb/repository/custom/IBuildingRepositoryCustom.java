package com.javaweb.repository.custom;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.request.BuildingSearchRequest;

import java.util.List;

public interface IBuildingRepositoryCustom {
    List<BuildingEntity> getAllBuildings(BuildingSearchRequest buildingSearchRequest);
}
