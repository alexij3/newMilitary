package com.vyshyvan.services.platoon;

import com.vyshyvan.model.Platoon;

import java.util.List;

public interface PlatoonService {
    Platoon insertPlatoon(Platoon platoon);
    Platoon getPlatoon(int id);
    Platoon updatePlatoon(Platoon platoon);
    void deletePlatoon(int id);
    List<Platoon> getAll();
}
