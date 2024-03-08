package com.javaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="building")
public class BuildingEntity extends BaseEntity{
    @Column(name="name")
    private String name;
    @Column(name="floorarea")
    private Long floorArea;
    @Column(name="district")
    private String district;
    @Column(name="ward")
    private String ward;
    @Column(name="street")
    private String street;
    @Column(name="numberofbasement")
    private Long numberOfBasement;
    @Column(name="direction")
    private String direction;
    @Column(name="level")
    private Long level;
    @Column(name="rentprice")

    private Long rentPrice;
    @Column(name="managername")
    private String managerName;
    @Column(name="managerphone")
    private String managerPhone;

    @ManyToMany
    @JoinTable(name= "assignmentbuilding",
    joinColumns = @JoinColumn(name="buildingid",nullable=false),
    inverseJoinColumns = @JoinColumn(name="staffid",nullable = false)
    )
    private List<UserEntity> userEntities = new ArrayList<>();

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Long floorArea) {
        this.floorArea = floorArea;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Long numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Long rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

}
