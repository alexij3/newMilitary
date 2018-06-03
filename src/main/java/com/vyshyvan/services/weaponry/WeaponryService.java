package com.vyshyvan.services.weaponry;

import com.vyshyvan.model.Weaponry;

import java.util.List;

public interface WeaponryService {
    Weaponry insertWeaponry(Weaponry weaponry);
    Weaponry getWeaponry(int id);
    Weaponry updateWeaponry(Weaponry weaponry);
    void deleteWeaponry(int id);
    List<Weaponry> getAll();
}
