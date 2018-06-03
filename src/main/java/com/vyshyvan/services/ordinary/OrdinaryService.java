package com.vyshyvan.services.ordinary;

import com.vyshyvan.model.Ordinary;
import com.vyshyvan.model.Rang;

import java.util.List;

public interface OrdinaryService {
    Ordinary insertOrdinary(Ordinary ordinary);
    Ordinary getOrdinary(int id);
    Ordinary updateOrdinary(Ordinary ordinary);
    void deleteOrdinary(int id);
    List<Ordinary> getAll();

    List<Ordinary> findAllByRang(Rang rang);
    List<Ordinary> findAllByRangAndSoldierMilitaryBase_Id(Rang rang, int id);
    List<Ordinary> findAllByRangAndDivisionId(Rang rang, int id);
    List<Ordinary> findAllByRangAndArmyId(Rang rang, int id);
}