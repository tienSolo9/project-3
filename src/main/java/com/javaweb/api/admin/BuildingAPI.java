package com.javaweb.api.admin;

import com.javaweb.converter.BuildingConverter;
import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.repository.IAssignmentBuildingRes;
import com.javaweb.repository.IBuildingRepository;
import com.javaweb.repository.IRentAreaEntityRepository;
import com.javaweb.service.IBuildingService;
import com.javaweb.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {
    @Autowired
    IRentAreaEntityRepository iRentAreaEntityRepository;
    @Autowired
    IBuildingService iBuildingService;
    @Autowired
    IBuildingRepository iBuildingRepository;
    @Autowired
    BuildingConverter buildingConverter;
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    IAssignmentBuildingRes iAssignmentBuildingRes;

    @GetMapping("/{id}/staffs")
    public ResponseDTO loadStaffs(@PathVariable Long id) {
        ResponseDTO temp = iBuildingService.Staffs(id);
        return temp;
    }

    @PutMapping("/update")
    @Transactional
    public void UpdateBuilding(@RequestBody BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = buildingConverter.toBuildingEntity(buildingDTO);
        BuildingEntity buildingAfterChanged = entityManager.merge(buildingEntity);
        iRentAreaEntityRepository.deleteAllByBuildingEntity_id(buildingDTO.getId());
        iBuildingService.saveAllRentAreas(buildingDTO.getRentArea(),buildingAfterChanged);
    }
    @PostMapping("/assginmentBuilding")
    @Transactional
    public void AssignmentBuilding(@RequestBody AssignmentBuildingDTO data) {
        iAssignmentBuildingRes.deleteAllByBuildingid(data.getBuildingId());
        iBuildingService.saveAllAssignmentBuildings(data.getBuildingId(), data.getStaffs());
    }
    @DeleteMapping("/delete/{ids}")
    @Transactional
    public void deleteBuilding(@PathVariable List<Long> ids) {
        iRentAreaEntityRepository.deleteAllByBuildingEntity_idIn(ids);
        iBuildingRepository.deleteAllByIdIn(ids);
    }
}
