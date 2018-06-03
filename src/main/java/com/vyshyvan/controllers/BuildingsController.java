package com.vyshyvan.controllers;

import com.vyshyvan.model.Buildings;
import com.vyshyvan.services.buildings.BuildingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/buildings")
public class BuildingsController {
    @Autowired
    BuildingsService buildingsService;

    @RequestMapping("/showall")
    public List<Buildings> showArmies(){
        return buildingsService.getAll();
    }

    @RequestMapping("/create")
    public Buildings create(@RequestBody Buildings buildings) {
        return buildingsService.insertBuildings(buildings);
    }

    @RequestMapping("/update")
    public Buildings updateBuildings(@RequestParam("id") Integer id, @RequestBody Buildings buildings) {
        buildings.setId(id);
        return buildingsService.updateBuildings(buildings);
    }

    @RequestMapping("/delete")
    public void deleteBuildings(@RequestParam("id") int id){
        buildingsService.deleteBuildings(id);
    }

    @RequestMapping("/get")
    public Buildings get(@RequestParam("id") int id){
        return buildingsService.getBuildings(id);
    }

    @RequestMapping("/findAllByMoreThanOneUnit")
    public List<Buildings> findAllByMoreThanOneUnit(){
        return buildingsService.findAllByMoreThanOneUnit();
    }

    @RequestMapping("/findAllByNoUnits")
    public List<Buildings> findAllByNoUnits(){
        return buildingsService.findAllByNoUnits();
    }
}

