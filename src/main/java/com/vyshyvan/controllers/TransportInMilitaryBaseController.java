package com.vyshyvan.controllers;

import com.vyshyvan.model.MilitaryBase;
import com.vyshyvan.model.Transport;
import com.vyshyvan.model.TransportInMilitaryBase;
import com.vyshyvan.model.TransportType;
import com.vyshyvan.services.transportinmilitarybase.TransportInMilitaryBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transportinmbase")
public class TransportInMilitaryBaseController {
    @Autowired
    TransportInMilitaryBaseServiceImpl transportInMilitaryBaseService;

    @RequestMapping("/showall")
    public List<TransportInMilitaryBase> showTransportInMilitaryBases(){
        return transportInMilitaryBaseService.getAll();
    }

    @RequestMapping("/insert")
    public TransportInMilitaryBase create(@RequestParam("mbaseId") int mbaseId,
                                          @RequestParam("transportId") int transportId,
                                          @RequestParam("amount") int amount){
        MilitaryBase militaryBase = new MilitaryBase();
        militaryBase.setId(mbaseId);

        Transport transport = new Transport();
        transport.setId(transportId);

        TransportInMilitaryBase transportInMilitaryBase = new TransportInMilitaryBase(militaryBase, transport, amount);
        return transportInMilitaryBaseService.insertTransportInMilitaryBase(transportInMilitaryBase);
    }

    @RequestMapping("/update")
    public TransportInMilitaryBase update(@RequestParam("id") int id,
                                          @RequestParam("mbaseId") int mbaseId,
                                          @RequestParam("transportId") int transportId,
                                          @RequestParam("amount") int amount){
        MilitaryBase militaryBase = new MilitaryBase();
        militaryBase.setId(mbaseId);

        Transport transport = new Transport();
        transport.setId(transportId);

        TransportInMilitaryBase transportInMilitaryBase = new TransportInMilitaryBase(militaryBase, transport, amount);
        transportInMilitaryBase.setId(id);
        return transportInMilitaryBaseService.updateTransportInMilitaryBase(transportInMilitaryBase);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam int id){
        transportInMilitaryBaseService.deleteTransportInMilitaryBase(id);
    }

    @RequestMapping("/findAllByTransportType")
    public List<TransportInMilitaryBase> findAllByTransportType(@RequestParam("type") TransportType type){
        return transportInMilitaryBaseService.findAllByTransportType(type);
    }

    @RequestMapping("/findAllByBaseAndTransportType")
    public List<TransportInMilitaryBase> findAllByBaseAndTransportType(@RequestParam("id") int id,
                                                                       @RequestParam("type") TransportType type){
        return transportInMilitaryBaseService.findAllByBaseAndTransportType(id, type);
    }

    @RequestMapping("/findAllByArmyAndTransportType")
    public List<TransportInMilitaryBase> findAllByArmyAndTransportType(@RequestParam("id") long id,
                                                                       @RequestParam("type") TransportType type){
        return transportInMilitaryBaseService.findAllByArmyAndTransportType(id, type);
    }

    @RequestMapping("/findAllByDivisionAndTransportType")
    public List<TransportInMilitaryBase> findAllByDivisionAndTransportType(@RequestParam("id") int id,
                                                                       @RequestParam("type") TransportType type){
        return transportInMilitaryBaseService.findAllByDivisionAndTransportType(id, type);
    }

    @RequestMapping("/findAllByCorpsAndTransportType")
    public List<TransportInMilitaryBase> findAllByCorpsAndTransportType(@RequestParam("id") int id,
                                                                       @RequestParam("type") TransportType type){
        return transportInMilitaryBaseService.findAllByCorpsAndTransportType(id, type);
    }
}
