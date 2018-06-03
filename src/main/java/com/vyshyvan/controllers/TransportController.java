package com.vyshyvan.controllers;


import com.vyshyvan.model.Transport;
import com.vyshyvan.services.transport.TransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transport")
public class TransportController {
    @Autowired
    TransportServiceImpl transportService;

    @RequestMapping("/showall")
    public List<Transport> showTransport(){
        return transportService.getAll();
    }

    @RequestMapping("/insert")
    public Transport insert(@RequestBody Transport transport){
        return transportService.insertTransport(transport);
    }

    @RequestMapping("/update")
    public Transport update(@RequestParam("id") int id, @RequestBody Transport transport){
        transport.setId(id);
        return transportService.updateTransport(transport);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id){
        transportService.deleteTransport(id);
    }

}
