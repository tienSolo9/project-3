package com.javaweb.api.admin;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value="kekek")
@RequestMapping("/api/building")
public class BuildingAPI {

    @Autowired
    IBuildingService iBuildingService;

    @PostMapping
    public BuildingSearchRequest updateBuilding(@RequestBody BuildingSearchRequest buildingSearchRequest){
        return buildingSearchRequest;
    }
    @PostMapping("/add")
    public AssignmentBuildingDTO AddBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO){
        return assignmentBuildingDTO;
    }
    @DeleteMapping("/{ids}")
    public void deleteBuilding(@PathVariable List<Long> ids){
            System.out.println("kekeke");
    }

    @GetMapping("/{id}/staffs")
    public ResponseDTO loadStaffs(@PathVariable Long id){
        ResponseDTO temp = iBuildingService.Staffs(id);

        return temp;
    }

}
