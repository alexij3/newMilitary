package com.vyshyvan.services.officers;

import com.vyshyvan.model.Officers;
import com.vyshyvan.model.Rang;

import java.util.List;

public interface OfficersService {
    Officers insertOfficers(Officers officers);
    Officers getOfficers(int id);
    Officers updateOfficers(Officers officers);
    void deleteOfficers(int id);
    List<Officers> getAll();

    List<Officers> findAllByRang(Rang rang);
    List<Officers> findAllByRangAndSoldierMilitaryBase_Id(Rang rang, int id);
    List<Officers> findAllByRangAndDivisionId(Rang rang, int id);
    List<Officers> findAllByRangAndArmyId(Rang rang, int id);
}
