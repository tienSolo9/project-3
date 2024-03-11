package com.javaweb.controller.admin;



import com.javaweb.converter.BuildingConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.enums.buildingType;
import com.javaweb.enums.districtCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.IBuildingRepository;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller(value="buildingControllerOfAdmin")
public class BuildingController {
    @Autowired
    UserService userService;
    @Autowired
    IBuildingService iBuildingService;
    @Autowired
    IBuildingRepository iBuildingRepository;
    @Autowired
    BuildingConverter buildingConverter;
    @GetMapping(value="/admin/building-list")
    public ModelAndView buildingList(@ModelAttribute BuildingSearchRequest buildingSearchRequest, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/list");

        // process data
        List<BuildingSearchResponse> buildingList = iBuildingService.findAllBuilding(buildingSearchRequest);

        //
        Map<Long,String> rs = userService.getStaffs();


        mav.addObject("buildingList", buildingList);
        mav.addObject("StaffList", rs);
        mav.addObject("modelSearch", buildingSearchRequest);
        mav.addObject("districtC", districtCode.type());
        mav.addObject("typeCodeC", buildingType.type());
        return mav;
    }

    @GetMapping(value="/admin/building-edit")
    public ModelAndView buildingAdd(@ModelAttribute BuildingSearchRequest buildingSearchRequest, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/edit");

        mav.addObject("modelEdit",buildingSearchRequest);
        mav.addObject("districtC", districtCode.type());
        mav.addObject("typeCodeC", buildingType.type());
        return mav;
    }

    @GetMapping(value="/admin/building-edit-{id}")
    public ModelAndView buildingUpdate(@PathVariable("id") Long id, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/edit");
        BuildingEntity buildingEntity = iBuildingRepository.findById(id).get();
        BuildingSearchRequest buildingSearchRequest = buildingConverter.toBuildingRequest(buildingEntity);

        mav.addObject("modelEdit",buildingSearchRequest);
        mav.addObject("districtC", districtCode.type());
        mav.addObject("typeCodeC", buildingType.type());
        return mav;
    }
}
