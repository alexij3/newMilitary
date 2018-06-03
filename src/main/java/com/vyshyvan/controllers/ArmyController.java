package com.vyshyvan.controllers;

import com.vyshyvan.model.Army;
import com.vyshyvan.repositories.army.ArmyDAO;
import com.vyshyvan.services.army.ArmyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/army")
public class ArmyController {
    @Autowired
    ArmyServiceImpl armyService;

    @Autowired
    ArmyDAO armyDAO;

    @RequestMapping("/showall")
    public List<Army> showArmies(){
        return armyService.getAll();
    }

    @RequestMapping("/create")
    public Army create(@RequestBody Army army) {
        return armyService.insertArmy(army);
    }

    @RequestMapping("/update")
    public Army updateArmy(@RequestParam("id") Long id, @RequestBody Army army) {
        army.setId(id);
        return armyService.updateArmy(army);
    }

    @RequestMapping("/delete")
    public void deleteArmy(@RequestParam("id") int id){
        armyService.deleteArmy(id);
    }

    @RequestMapping("/get")
    public Army get(@RequestParam("id") int id){
        return armyService.getArmy(id);
    }

    @RequestMapping("/findByMaxBases")
    public List<Army> findByMaxBases(){
        return armyDAO.findArmyByMaxBases();
    }

    @RequestMapping("/findByMinBases")
    public List<Army> findByMinBases(){
        return armyDAO.findArmyByMinBases();
    }

}
