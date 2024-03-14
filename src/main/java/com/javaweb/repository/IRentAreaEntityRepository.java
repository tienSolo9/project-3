package com.javaweb.repository;

import com.javaweb.entity.RentAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRentAreaEntityRepository extends JpaRepository<RentAreaEntity, Long> {
//    List<RentAreaEntity> findByBuildingEntity_id(List<Long> id);
    List<RentAreaEntity> findByBuildingEntity_id(Long id);

    RentAreaEntity findByBuildingEntity_idAndValue(Long id, Integer value);

    void deleteAllByBuildingEntity_idIn(List<Long> id);
    void deleteAllByBuildingEntity_id(Long id);
}
