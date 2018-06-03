package com.vyshyvan.controllers;

import com.vyshyvan.model.Brigade;
import com.vyshyvan.services.brigade.BrigadeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brigade")
public class BrigadeController {
    @Autowired
    BrigadeServiceImpl brigadeService;

    @RequestMapping("/showall")
    public List<Brigade> showArmies(){
        return brigadeService.getAll();
    }

    @RequestMapping("/create")
    public Brigade create(@RequestBody Brigade brigade) {
        return brigadeService.insertBrigade(brigade);
    }

    @RequestMapping("/update")
    public Brigade updateBrigade(@RequestParam("id") Integer id, @RequestBody Brigade brigade) {
        brigade.setId(id);
        return brigadeService.updateBrigade(brigade);
    }

    @RequestMapping("/delete")
    public void deleteBrigade(@RequestParam("id") int id){
        brigadeService.deleteBrigade(id);
    }

    @RequestMapping("/get")
    public Brigade get(@RequestParam("id") int id){
        return brigadeService.getBrigade(id);
    }

}

