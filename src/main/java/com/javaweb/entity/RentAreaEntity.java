package com.javaweb.entity;

import javax.persistence.*;

@Entity
@Table(name="rentarea")
public class RentAreaEntity extends BaseEntity{
    @Column(name="value")
    private Integer value;

    @ManyToOne
    @JoinColumn(name="buildingid")
    private BuildingEntity buildingEntity;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public BuildingEntity getBuildingEntity() {
        return buildingEntity;
    }

    public void setBuildingEntity(BuildingEntity buildingEntity) {
        this.buildingEntity = buildingEntity;
    }
}
