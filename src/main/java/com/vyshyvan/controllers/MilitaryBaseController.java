package com.vyshyvan.controllers;

import com.vyshyvan.model.*;
import com.vyshyvan.repositories.militarybase.MilitaryBaseDAO;
import com.vyshyvan.services.army.ArmyServiceImpl;
import com.vyshyvan.services.division.DivisionService;
import com.vyshyvan.services.militarybase.MilitaryBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/militarybase")
public class MilitaryBaseController {
    @Autowired
    MilitaryBaseServiceImpl militaryBaseService;

    @Autowired
    ArmyServiceImpl armyService;

    @RequestMapping("/showall")
    public List<MilitaryBase> showMilitaryBases(){
        return militaryBaseService.getAll();
    }

    @RequestMapping("/create")
    public MilitaryBase create(long armyId, int divisionId, int corpsId, int brigadeId, int captainId, int dislocationId,
                               @RequestBody MilitaryBase militaryBaseInput){
        Army army = new Army();
        Buildings buildings = new Buildings();
        Division division;
        Corps corps;
        Brigade brigade;
        Soldier soldier;

        MilitaryBase militaryBase = new MilitaryBase();

        army.setId(armyId);
        buildings.setId(dislocationId);

        if (divisionId != 0){
            division = new Division();
            division.setId(divisionId);
            militaryBase.setDivision(division);
        }else if (corpsId != 0) {
            corps = new Corps();
            corps.setId(corpsId);
            militaryBase.setCorps(corps);
        }else if (brigadeId != 0){
            brigade = new Brigade();
            brigade.setId(brigadeId);
            militaryBase.setBrigade(brigade);
        }

        if (captainId != 0){
            soldier = new Soldier();
            soldier.setId(captainId);
            militaryBase.setCaptain(soldier);
        }

        militaryBase.setName(militaryBaseInput.getName());
        militaryBase.setArmy(army);

        return militaryBaseService.insertMilitaryBase(militaryBase);
    }

    @RequestMapping("/update")
    public MilitaryBase update(int id, long armyId, int divisionId, int corpsId, int brigadeId, int captainId, int dislocationId,
                               @RequestBody MilitaryBase militaryBaseInput){
        Army army = new Army();
        Buildings buildings = new Buildings();
        Division division;
        Corps corps;
        Brigade brigade;
        Soldier soldier;

        MilitaryBase militaryBase = new MilitaryBase();
        militaryBase.setId(id);

        army.setId(armyId);
        buildings.setId(dislocationId);

        if (divisionId != 0){
            division = new Division();
            division.setId(divisionId);
            militaryBase.setDivision(division);
        }else if (corpsId != 0) {
            corps = new Corps();
            corps.setId(corpsId);
            militaryBase.setCorps(corps);
        }else if (brigadeId != 0){
            brigade = new Brigade();
            brigade.setId(brigadeId);
            militaryBase.setBrigade(brigade);
        }

        if (captainId != 0){
            soldier = new Soldier();
            soldier.setId(captainId);
            militaryBase.setCaptain(soldier);
        }

        militaryBase.setName(militaryBaseInput.getName());
        militaryBase.setArmy(army);

        return militaryBaseService.updateMilitaryBase(militaryBase);
    }

    @RequestMapping("/get")
    public MilitaryBase get(@RequestParam("id") int id){
        return militaryBaseService.getMilitaryBase(id);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id){
        militaryBaseService.deleteMilitaryBase(id);
    }

    @RequestMapping("/findAllByArmyId")
    public List<MilitaryBase> findAllByArmyId(@RequestParam("id") int id){
        return militaryBaseService.findAllByArmyId(id);
    }

    @RequestMapping("/findAllByDivisionId")
    public List<MilitaryBase> findAllByDivisionId(@RequestParam("id") int id){
        return militaryBaseService.findAllByDivisionId(id);
    }

    @RequestMapping("/findAllByCorpsId")
    public List<MilitaryBase> findAllByCorpsId(@RequestParam("id") int id){
        return militaryBaseService.findAllByCorpsId(id);
    }

}