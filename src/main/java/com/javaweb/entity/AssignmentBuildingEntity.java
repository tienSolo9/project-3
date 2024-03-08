//package com.javaweb.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//@Entity
//@Table(name="assignmentbuilding")
//public class AssignmentBuildingEntity extends BaseEntity{
//
//    @ManyToOne
//    @JoinColumn(name="staffid")
//    private BuildingEntity buildngMap;
//
//    @ManyToOne
//    @JoinColumn(name="userid")
//    private UserEntity userMap;
//
//    public BuildingEntity getBuildngMap() {
//        return buildngMap;
//    }
//
//    public void setBuildngMap(BuildingEntity buildngMap) {
//        this.buildngMap = buildngMap;
//    }
//
//    public UserEntity getUserMap() {
//        return userMap;
//    }
//
//    public void setUserMap(UserEntity userMap) {
//        this.userMap = userMap;
//    }
//}
