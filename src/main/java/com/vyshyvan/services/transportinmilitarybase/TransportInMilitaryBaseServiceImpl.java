package com.vyshyvan.services.transportinmilitarybase;

import com.vyshyvan.model.TransportInMilitaryBase;
import com.vyshyvan.model.TransportType;
import com.vyshyvan.repositories.transportinmilitarybase.TransportInMilitaryBaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportInMilitaryBaseServiceImpl implements TransportInMilitaryBaseService{
    @Autowired
    TransportInMilitaryBaseDAO transportInMilitaryBaseDAO;

    @Override
    public TransportInMilitaryBase insertTransportInMilitaryBase(TransportInMilitaryBase transportInMilitaryBase) {
        return transportInMilitaryBaseDAO.save(transportInMilitaryBase);
    }

    @Override
    public TransportInMilitaryBase getTransportInMilitaryBase(int id) {
        return transportInMilitaryBaseDAO.findById(id).get();
    }

    @Override
    public TransportInMilitaryBase updateTransportInMilitaryBase(TransportInMilitaryBase transportInMilitaryBase) {
        return transportInMilitaryBaseDAO.save(transportInMilitaryBase);
    }

    @Override
    public void deleteTransportInMilitaryBase(int id) {
        transportInMilitaryBaseDAO.deleteById(id);
    }

    @Override
    public List<TransportInMilitaryBase> getAll() {
        return (List<TransportInMilitaryBase>) transportInMilitaryBaseDAO.findAll();
    }

    @Override
    public List<TransportInMilitaryBase> findAllByTransportType(TransportType type) {
        return transportInMilitaryBaseDAO.findAllByTransportType(type);
    }

    @Override
    public List<TransportInMilitaryBase> findAllByBaseAndTransportType(int id, TransportType type) {
        return transportInMilitaryBaseDAO.findAllByBaseAndTransportType(id, type);
    }

    @Override
    public List<TransportInMilitaryBase> findAllByArmyAndTransportType(long id, TransportType type) {
        return transportInMilitaryBaseDAO.findAllByArmyAndTransportType(id, type);
    }

    @Override
    public List<TransportInMilitaryBase> findAllByDivisionAndTransportType(int id, TransportType type) {
        return transportInMilitaryBaseDAO.findAllByDivisionAndTransportType(id, type);
    }

    @Override
    public List<TransportInMilitaryBase> findAllByCorpsAndTransportType(int id, TransportType type) {
        return transportInMilitaryBaseDAO.findAllByCorpsAndTransportType(id, type);
    }
}
