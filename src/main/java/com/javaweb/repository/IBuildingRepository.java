package com.javaweb.repository;

import com.javaweb.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBuildingRepository extends JpaRepository<BuildingEntity,Long> {
    void deleteAllByIdIn(List<Long> ids);
}
