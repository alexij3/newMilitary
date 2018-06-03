package com.vyshyvan.services.soldier;

import com.vyshyvan.model.Soldier;
import com.vyshyvan.model.Specialty;

import java.util.List;

public interface SoldierService {
    Soldier insertSoldier(Soldier soldier);
    Soldier getSoldier(int id);
    Soldier updateSoldier(Soldier soldier);
    void deleteSoldier(int id);
    void updateSpecialties(Soldier soldier);
    void deleteSpecialties(Soldier soldier);
    List<Soldier> getAll();
    List<Soldier> findAllBySpecialtyContainingAndMilitaryBase_ArmyId(Specialty specialty, long id);
    List<Soldier> findAllBySpecialtyContainingAndMilitaryBaseId(Specialty specialty, int id);
    List<Soldier> findAllBySpecialtyContainingAndMilitaryBase_Division_Id(Specialty specialty, int id);
    List<Soldier> findAllBySpecialtyContainingAndMilitaryBase_Corps_Id(Specialty specialty, int id);
    List<Soldier> findAllBySpecialtyContainingAndMilitaryBase_Brigade_Id(Specialty specialty, int id);
}
