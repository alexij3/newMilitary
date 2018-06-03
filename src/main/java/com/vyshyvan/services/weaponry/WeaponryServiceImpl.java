package com.vyshyvan.services.weaponry;

import com.vyshyvan.model.Weaponry;
import com.vyshyvan.repositories.weaponry.WeaponryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WeaponryServiceImpl implements WeaponryService{
    @Autowired
    WeaponryDAO weaponryDAO;

    @Override
    public Weaponry insertWeaponry(Weaponry weaponry) {
        return weaponryDAO.save(weaponry);
    }

    @Override
    public Weaponry getWeaponry(int id) {
        return weaponryDAO.findById(id).get();
    }

    @Override
    public Weaponry updateWeaponry(Weaponry weaponry) {
        return weaponryDAO.save(weaponry);
    }

    @Override
    public void deleteWeaponry(int id) {
        weaponryDAO.deleteById(id);
    }

    @Override
    public List<Weaponry> getAll() {
        return (List<Weaponry>) weaponryDAO.findAll();
    }
}