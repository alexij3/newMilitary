package com.vyshyvan.controllers;

import com.vyshyvan.model.Division;
import com.vyshyvan.repositories.division.DivisionDAO;
import com.vyshyvan.services.division.DivisionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/division")
public class DivisionController {
    @Autowired
    DivisionServiceImpl divisionService;

    @Autowired
    DivisionDAO divisionDAO;

    @RequestMapping("/showall")
    public List<Division> showDivisions(){
        return divisionService.getAll();
    }

    @RequestMapping("/create")
    public Division create(@RequestBody Division division) {
        return divisionService.insertDivision(division);
    }

    @RequestMapping("/update")
    public Division updateDivision(@RequestParam("id") Integer id, @RequestBody Division division) {
        division.setId(id);
        return divisionService.updateDivision(division);
    }

    @RequestMapping("/delete")
    public void deleteDivision(@RequestParam("id") int id){
        divisionService.deleteDivision(id);
    }

    @RequestMapping("/get")
    public Division get(@RequestParam("id") int id){
        return divisionService.getDivision(id);
    }

    @RequestMapping("/findByMaxBases")
    public List<Division> findByMaxBases(){
        return divisionDAO.findByMaxBases();
    }

    @RequestMapping("/findByMinBases")
    public List<Division> findByMinBases(){
        return divisionDAO.findByMinBases();
    }
}