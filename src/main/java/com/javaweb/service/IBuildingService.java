package com.javaweb.service;

import com.javaweb.model.response.ResponseDTO;
import com.javaweb.repository.custom.IBuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface IBuildingService {
    ResponseDTO Staffs(Long buildingId);
}
