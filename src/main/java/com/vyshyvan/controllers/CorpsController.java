package com.vyshyvan.controllers;


import com.vyshyvan.model.Corps;
import com.vyshyvan.repositories.corps.CorpsDAO;
import com.vyshyvan.services.corps.CorpsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/corps")
public class CorpsController {
    @Autowired
    CorpsServiceImpl corpsService;

    @Autowired
    CorpsDAO corpsDAO;

    @RequestMapping("/showall")
    public List<Corps> showCorps(){
        return corpsService.getAll();
    }

    @RequestMapping("/create")
    public Corps create(@RequestBody Corps corps) {
        return corpsService.insertCorps(corps);
    }

    @RequestMapping("/update")
    public Corps updateCorps(@RequestParam("id") Integer id, @RequestBody Corps corps) {
        corps.setId(id);
        return corpsService.updateCorps(corps);
    }

    @RequestMapping("/delete")
    public void deleteCorps(@RequestParam("id") int id){
        corpsService.deleteCorps(id);
    }

    @RequestMapping("/get")
    public Corps get(@RequestParam("id") int id){
        return corpsService.getCorps(id);
    }

    @RequestMapping("/findByMaxBases")
    public List<Corps> findByMaxBases(){
        return corpsDAO.findByMaxBases();
    }

    @RequestMapping("/findByMinBases")
    public List<Corps> findByMinBases(){
        return corpsDAO.findByMinBases();
    }
}

