package com.javaweb.controller.admin;



import com.javaweb.enums.buildingType;
import com.javaweb.enums.districtCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
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

    @GetMapping(value="/admin/building-list")
    public ModelAndView buildingList(@ModelAttribute BuildingDTO buildingDTO, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/list");

        // process data
        List<BuildingSearchResponse> buildingList = new ArrayList<>();

        BuildingSearchResponse building1 = new BuildingSearchResponse();
        building1.setId(1L);
        building1.setName("Tien pham tower");
        building1.setAddress("phu dien huu hoa thanh tri ha noi");
        building1.setManagerName("tien dep trai");
        building1.setNumberOfBasement(10L);
        building1.setManagerPhone("0395527082");

        BuildingSearchResponse building2 = new BuildingSearchResponse();
        building2.setId(2L);
        building2.setName("Tien pham Bitexco");
        building2.setAddress("Ha noi");
        building2.setManagerName("tien dep trai");
        building2.setNumberOfBasement(12L);
        building2.setManagerPhone("0395527082");

        buildingList.add(building1);
        buildingList.add(building2);

        Map<Long,String> rs = userService.getStaffs();


        mav.addObject("buildingList1", buildingList);
        mav.addObject("StaffList", rs);
        mav.addObject("modelSearch", buildingDTO);
        mav.addObject("districtC", districtCode.type());
        mav.addObject("typeCodeC", buildingType.type());
        return mav;
    }

    @GetMapping(value="/admin/building-edit")
    public ModelAndView buildingEdit(@ModelAttribute BuildingSearchRequest buildingSearchRequest, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/edit");

        mav.addObject("modelEdit",buildingSearchRequest);
        mav.addObject("districtC", districtCode.type());
        mav.addObject("typeCodeC", buildingType.type());
        return mav;
    }

    @GetMapping(value="/admin/building-edit-{id}")
    public ModelAndView buildingUpdate(@PathVariable("id") Long id, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/edit");
        BuildingSearchRequest buildingSearchRequest = new BuildingSearchRequest();
        buildingSearchRequest.setId(id);

        mav.addObject("modelEdit",buildingSearchRequest);
        mav.addObject("districtC", districtCode.type());
        mav.addObject("typeCodeC", buildingType.type());
        return mav;
    }
}
