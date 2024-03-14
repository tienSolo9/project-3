package com.javaweb.repository.custom;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.BuildingDTO;

import java.util.List;

public interface IBuildingRepositoryCustom {
    List<BuildingEntity> getAllBuildings(BuildingDTO buildingDTO);
}
