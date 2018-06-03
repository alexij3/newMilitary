package com.vyshyvan.controllers;

import com.vyshyvan.model.Weaponry;
import com.vyshyvan.services.weaponry.WeaponryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/weaponry")
public class WeaponryController {
    @Autowired
    WeaponryServiceImpl weaponryService;

    @RequestMapping("/showall")
    public List<Weaponry> showWeaponry(){
        return weaponryService.getAll();
    }

    @RequestMapping("/insert")
    public Weaponry insert(@RequestBody Weaponry weaponry){
        return weaponryService.insertWeaponry(weaponry);
    }

    @RequestMapping("/update")
    public Weaponry update(@RequestParam("weaponryId") int id, @RequestBody Weaponry weaponry){
        weaponry.setId(id);
        return weaponryService.updateWeaponry(weaponry);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id){
        weaponryService.deleteWeaponry(id);
    }

}
