package com.javaweb.repository;

import com.javaweb.entity.RentAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRentAreaEntityRepository extends JpaRepository<RentAreaEntity, Long> {
    List<RentAreaEntity> findRentAreaEntitiesByBuildingEntity_id(List<Long> id);
    void deleteAllByBuildingEntity_idIn(List<Long> id);
    void deleteAllByBuildingEntity_id(Long id);
}
