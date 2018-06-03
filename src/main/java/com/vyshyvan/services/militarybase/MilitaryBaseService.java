package com.vyshyvan.services.militarybase;

import com.vyshyvan.model.Corps;
import com.vyshyvan.model.Division;
import com.vyshyvan.model.MilitaryBase;
import com.vyshyvan.model.WeaponryType;

import java.util.List;

public interface MilitaryBaseService {
    MilitaryBase insertMilitaryBase(MilitaryBase militaryBase);
    MilitaryBase getMilitaryBase(int id);
    MilitaryBase updateMilitaryBase(MilitaryBase militaryBase);
    void deleteMilitaryBase(int id);
    List<MilitaryBase> getAll();
    List<MilitaryBase> findAllByArmyId(int id);
    List<MilitaryBase> findAllByDivisionId(int id);
    List<MilitaryBase> findAllByCorpsId(int id);
}
