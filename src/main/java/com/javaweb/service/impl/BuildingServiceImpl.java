package com.javaweb.service.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.UserRepository;
import com.javaweb.repository.custom.IBuildingRepository;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingServiceImpl implements IBuildingService {
    @Autowired
    IBuildingRepository iBuildingRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseDTO Staffs(Long buildingId) {
        BuildingEntity buildingEntity = iBuildingRepository.findById(buildingId).get();
        List<UserEntity> staffs = userRepository.findByStatusAndRoles_code(1,"STAFF");
        List<UserEntity> staffsInCharge = buildingEntity.getUserEntities();

        ResponseDTO result = new ResponseDTO();
        List<StaffResponseDTO> ListSt = new ArrayList<>();
        for(UserEntity it: staffs){
            StaffResponseDTO item = new StaffResponseDTO();
            item.setStaffId(it.getId());
            item.setFullName(it.getFullName());

            if(staffsInCharge.contains(it)){
                item.setChecked("checked");
            }
            else{
                item.setChecked("");
            }
            ListSt.add(item);
        }

        result.setData(ListSt);
        result.setMessage("success");
        return result;
    }
}
