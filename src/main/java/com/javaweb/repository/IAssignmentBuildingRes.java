package com.javaweb.repository;

import com.javaweb.entity.AssignmentBuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAssignmentBuildingRes extends JpaRepository<AssignmentBuildingEntity,Long> {
    List<AssignmentBuildingEntity> findAssignmentBuildingEntitiesByBuildingid(Long buildingId);

    void deleteAllByBuildingid(Long id);
}
