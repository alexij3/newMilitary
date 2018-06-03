package com.vyshyvan.controllers;

import com.vyshyvan.model.Platoon;
import com.vyshyvan.model.Squadron;
import com.vyshyvan.services.platoon.PlatoonServiceImpl;
import com.vyshyvan.services.squadron.SquadronServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/platoon")
public class PlatoonController {
    @Autowired
    PlatoonServiceImpl platoonService;

    @Autowired
    SquadronServiceImpl squadronService;

    @RequestMapping("/showall")
    public List<Platoon> showPlatoons(){
        return platoonService.getAll();
    }

    @RequestMapping("/create")
    public Platoon create(@RequestParam("squadronId") int squadronId, @RequestBody Platoon platoon) {
        Squadron squadron = new Squadron();
        squadron.setId(squadronId);
        platoon.setSquadron(squadron);
        return platoonService.insertPlatoon(platoon);
    }

    @RequestMapping("/update")
    public Platoon updatePlatoon(@RequestParam("squadronId") Integer squadronId, @RequestParam("id") Integer id, @RequestBody Platoon platoon) {
        platoon.setId(id);
        Squadron squadron = new Squadron();
        if (squadronId != null){
            squadron.setId(squadronId);
            platoon.setSquadron(squadron);
        }
        return platoonService.updatePlatoon(platoon);
    }

    @RequestMapping("/delete")
    public void deletePlatoon(@RequestParam("id") int id){
        platoonService.deletePlatoon(id);
    }

    @RequestMapping("/get")
    public Platoon get(@RequestParam("id") int id){
        return platoonService.getPlatoon(id);
    }

}
