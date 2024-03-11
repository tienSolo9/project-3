package com.javaweb.api.admin;

import com.javaweb.converter.BuildingConverter;
import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.IAssignmentBuildingRes;
import com.javaweb.repository.IBuildingRepository;
import com.javaweb.service.IBuildingService;
import com.javaweb.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

    @Autowired
    IBuildingService iBuildingService;
    @Autowired
    BuildingConverter buildingConverter;
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    IAssignmentBuildingRes iAssignmentBuildingRes;
    @GetMapping("/{id}/staffs")
    public ResponseDTO loadStaffs(@PathVariable Long id){
        ResponseDTO temp = iBuildingService.Staffs(id);
        return temp;
    }
    @PutMapping("/update")
    @Transactional
    public void UpdateBuilding(@RequestBody BuildingSearchRequest buildingSearchRequest){
        BuildingEntity buildingEntity = buildingConverter.toBuildingEntity(buildingSearchRequest);
        entityManager.merge(buildingEntity);
    }

    @PostMapping("/assginmentBuilding")
    @Transactional
    public void AssignmentBuilding(@RequestBody AssignmentBuildingDTO data){
        List<AssignmentBuildingEntity> assignmentBuildingEntities = iAssignmentBuildingRes.findAssignmentBuildingEntitiesByBuildingid(data.getBuildingId());
        for(AssignmentBuildingEntity item: assignmentBuildingEntities){
            entityManager.remove(item);
        }

        for(Long item : data.getStaffs()){
            AssignmentBuildingEntity it = new AssignmentBuildingEntity();
            it.setBuildingid(data.getBuildingId());
            it.setStaffId(item);
            entityManager.persist(it);
        }
    }
    @DeleteMapping("/delete/{ids}")
    @Transactional
    public void deleteBuilding(@PathVariable List<Long> ids){

        List<BuildingEntity> buildingEntities = iBuildingService.getBuildingByIds(ids);

        for(BuildingEntity item : buildingEntities){
            List<RentAreaEntity> rentAreaEntities = iBuildingService.getRentAreasById(item.getId());
            for(RentAreaEntity it : rentAreaEntities){
                entityManager.remove(it);
            }
            entityManager.remove(item);
        }
        System.out.println("successfully delete");
    }
}
