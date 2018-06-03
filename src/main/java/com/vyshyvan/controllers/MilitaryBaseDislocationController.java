package com.vyshyvan.controllers;

import com.vyshyvan.model.Buildings;
import com.vyshyvan.model.MilitaryBase;
import com.vyshyvan.model.MilitaryBaseDislocation;
import com.vyshyvan.services.dislocation.MilitaryBaseDislocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dislocation")
public class MilitaryBaseDislocationController {
    @Autowired
    MilitaryBaseDislocationServiceImpl service;

    @RequestMapping("/insert")
    MilitaryBaseDislocation insert(@RequestParam("baseId") int baseId,
                                   @RequestParam("dislocationId") int dislocationId){
        System.out.println("in method");
        MilitaryBase militaryBase = new MilitaryBase();
        militaryBase.setId(baseId);

        Buildings dislocation = new Buildings();
        dislocation.setId(dislocationId);

        MilitaryBaseDislocation militaryBaseDislocation = new MilitaryBaseDislocation(militaryBase, dislocation);

        return service.insert(militaryBaseDislocation);
    }

    @RequestMapping("/get")
    MilitaryBaseDislocation get(int id){
        return service.get(id);
    }

    @RequestMapping("/update")
    MilitaryBaseDislocation update(@RequestParam("id") int id,
                                   @RequestParam("baseId") int baseId,
                                   @RequestParam("dislocationId") int dislocationId){

        System.out.println("in update");
        MilitaryBase militaryBase = new MilitaryBase();
        militaryBase.setId(baseId);

        Buildings dislocation = new Buildings();
        dislocation.setId(dislocationId);

        MilitaryBaseDislocation militaryBaseDislocation = new MilitaryBaseDislocation(militaryBase, dislocation);
        militaryBaseDislocation.setId(id);

        return service.update(militaryBaseDislocation);
    }

    @RequestMapping("/delete")
    void delete(int id){
        service.delete(id);
    }

    @RequestMapping("/showall")
    List<MilitaryBaseDislocation> getAll(){
        return service.getAll();
    }

    @RequestMapping("/findAllByMilitaryBaseId")
    List<MilitaryBaseDislocation> findAllByMilitaryBaseId(int id){
        return service.findAllByMilitaryBaseId(id);
    }

    @RequestMapping("/findAllByMilitaryBaseArmyId")
    List<MilitaryBaseDislocation> findAllByMilitaryBaseArmyId(long id){
        return service.findAllByMilitaryBaseArmy_Id(id);
    }

    @RequestMapping("/findAllByMilitaryBaseDivisionId")
    List<MilitaryBaseDislocation> findAllByMilitaryBaseDivisionId(int id){
        return service.findAllByMilitaryBaseDivision_Id(id);
    }

    @RequestMapping("/findAllByMilitaryBaseCorpsId")
    List<MilitaryBaseDislocation> findAllByMilitaryBaseCorpsId(int id){
        return service.findAllByMilitaryBaseCorps_Id(id);
    }
}
