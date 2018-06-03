package com.vyshyvan.services.transportinmilitarybase;

import com.vyshyvan.model.TransportInMilitaryBase;
import com.vyshyvan.model.TransportType;

import java.util.List;

public interface TransportInMilitaryBaseService {
    TransportInMilitaryBase insertTransportInMilitaryBase(TransportInMilitaryBase transportInMilitaryBase);
    TransportInMilitaryBase getTransportInMilitaryBase(int id);
    TransportInMilitaryBase updateTransportInMilitaryBase(TransportInMilitaryBase transportInMilitaryBase);
    void deleteTransportInMilitaryBase(int id);
    List<TransportInMilitaryBase> getAll();

    List<TransportInMilitaryBase> findAllByTransportType(TransportType type);
    List<TransportInMilitaryBase> findAllByBaseAndTransportType(int id, TransportType type);
    List<TransportInMilitaryBase> findAllByArmyAndTransportType(long id, TransportType type);
    List<TransportInMilitaryBase> findAllByDivisionAndTransportType(int id, TransportType type);
    List<TransportInMilitaryBase> findAllByCorpsAndTransportType(int id, TransportType type);
}
