package com.javaweb.repository.custom;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.BuildingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBuildingRepositoryCustom {
    Page<BuildingEntity> getAllBuildings(BuildingDTO buildingDTO, Pageable pageable);
    int countTotalItem();
}
