package com.vyshyvan.controllers;

import com.vyshyvan.model.MilitaryBase;
import com.vyshyvan.model.Weaponry;
import com.vyshyvan.model.WeaponryInMilitaryBase;
import com.vyshyvan.model.WeaponryType;
import com.vyshyvan.repositories.weaponryinmilitarybase.WeaponryInMilitaryBaseDAO;
import com.vyshyvan.services.weaponryinmilitarybase.WeaponryInMilitaryBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/weaponryinmbase")
public class WeaponryInMilitaryBaseController {
    @Autowired
    WeaponryInMilitaryBaseServiceImpl weaponryInMilitaryBaseService;

    @Autowired
    WeaponryInMilitaryBaseDAO dao;

    @RequestMapping("/showall")
    public List<WeaponryInMilitaryBase> showWeaponryInMilitaryBases(){
        return weaponryInMilitaryBaseService.getAll();
    }

    @RequestMapping("/insert")
    public WeaponryInMilitaryBase create(@RequestParam("mbaseId") int mbaseId,
                                          @RequestParam("weaponryId") int weaponryId,
                                          @RequestParam("amount") int amount){
        MilitaryBase militaryBase = new MilitaryBase();
        militaryBase.setId(mbaseId);

        Weaponry weaponry = new Weaponry();
        weaponry.setId(weaponryId);

        WeaponryInMilitaryBase weaponryInMilitaryBase = new WeaponryInMilitaryBase(militaryBase, weaponry, amount);
        return weaponryInMilitaryBaseService.insertWeaponryInMilitaryBase(weaponryInMilitaryBase);
    }

    @RequestMapping("/update")
    public WeaponryInMilitaryBase update(@RequestParam("id") int id,
                                          @RequestParam("mbaseId") int mbaseId,
                                          @RequestParam("weaponryId") int weaponryId,
                                          @RequestParam("amount") int amount){
        MilitaryBase militaryBase = new MilitaryBase();
        militaryBase.setId(mbaseId);

        Weaponry weaponry = new Weaponry();
        weaponry.setId(weaponryId);

        WeaponryInMilitaryBase weaponryInMilitaryBase = new WeaponryInMilitaryBase(militaryBase, weaponry, amount);
        weaponryInMilitaryBase.setId(id);
        return weaponryInMilitaryBaseService.updateWeaponryInMilitaryBase(weaponryInMilitaryBase);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam int id){
        weaponryInMilitaryBaseService.deleteWeaponryInMilitaryBase(id);
    }

    @RequestMapping("/findAllByWeaponryType")
    public List<WeaponryInMilitaryBase> findAllByWeaponryType(@RequestParam("type") WeaponryType type){
        return weaponryInMilitaryBaseService.findAllByWeaponryType(type);
    }

    @RequestMapping("/findAllByBaseAndWeaponryType")
    public List<WeaponryInMilitaryBase> findAllByBaseAndWeaponryType(@RequestParam("id") int id,
                                                                     @RequestParam("type") WeaponryType type){
        return weaponryInMilitaryBaseService.findAllByBaseAndWeaponryType(id, type);
    }

    @RequestMapping("/findAllByArmyAndWeaponryType")
    public List<WeaponryInMilitaryBase> findAllByArmyAndWeaponryType(@RequestParam("id") long id,
                                                                     @RequestParam("type") WeaponryType type){
        return weaponryInMilitaryBaseService.findAllByArmyAndWeaponryType(id, type);
    }

    @RequestMapping("/findAllByDivisionAndWeaponryType")
    public List<WeaponryInMilitaryBase> findAllByDivisionAndWeaponryType(@RequestParam("id") int id,
                                                                         @RequestParam("type") WeaponryType type){
        return weaponryInMilitaryBaseService.findAllByDivisionAndWeaponryType(id, type);
    }

    @RequestMapping("/findAllByCorpsAndWeaponryType")
    public List<WeaponryInMilitaryBase> findAllByCorpsAndWeaponryType(@RequestParam("id") int id,
                                                                      @RequestParam("type") WeaponryType type){
        return weaponryInMilitaryBaseService.findAllByCorpsAndWeaponryType(id, type);
    }

}
