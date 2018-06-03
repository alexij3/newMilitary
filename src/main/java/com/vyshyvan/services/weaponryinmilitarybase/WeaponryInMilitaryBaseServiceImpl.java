package com.vyshyvan.services.weaponryinmilitarybase;

import com.vyshyvan.model.WeaponryInMilitaryBase;
import com.vyshyvan.model.WeaponryType;
import com.vyshyvan.repositories.weaponryinmilitarybase.WeaponryInMilitaryBaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponryInMilitaryBaseServiceImpl implements WeaponryInMilitaryBaseService {
    @Autowired
    WeaponryInMilitaryBaseDAO weaponryInMilitaryBaseDAO;

    @Override
    public WeaponryInMilitaryBase insertWeaponryInMilitaryBase(WeaponryInMilitaryBase weaponryInMilitaryBase) {
        return weaponryInMilitaryBaseDAO.save(weaponryInMilitaryBase);
    }

    @Override
    public WeaponryInMilitaryBase getWeaponryInMilitaryBase(int id) {
        return weaponryInMilitaryBaseDAO.findById(id).get();
    }

    @Override
    public WeaponryInMilitaryBase updateWeaponryInMilitaryBase(WeaponryInMilitaryBase weaponryInMilitaryBase) {
        return weaponryInMilitaryBaseDAO.save(weaponryInMilitaryBase);
    }

    @Override
    public void deleteWeaponryInMilitaryBase(int id) {
        weaponryInMilitaryBaseDAO.deleteById(id);
    }

    @Override
    public List<WeaponryInMilitaryBase> getAll() {
        return (List<WeaponryInMilitaryBase>) weaponryInMilitaryBaseDAO.findAll();
    }

    @Override
    public List<WeaponryInMilitaryBase> findAllByWeaponryType(WeaponryType type) {
        return weaponryInMilitaryBaseDAO.findAllByWeaponryType(type);
    }

    @Override
    public List<WeaponryInMilitaryBase> findAllByBaseAndWeaponryType(int id, WeaponryType type) {
        return weaponryInMilitaryBaseDAO.findAllByBaseAndWeaponryType(id, type);
    }

    @Override
    public List<WeaponryInMilitaryBase> findAllByArmyAndWeaponryType(long id, WeaponryType type) {
        return weaponryInMilitaryBaseDAO.findAllByArmyAndWeaponryType(id, type);
    }

    @Override
    public List<WeaponryInMilitaryBase> findAllByDivisionAndWeaponryType(int id, WeaponryType type) {
        return weaponryInMilitaryBaseDAO.findAllByDivisionAndWeaponryType(id, type);
    }

    @Override
    public List<WeaponryInMilitaryBase> findAllByCorpsAndWeaponryType(int id, WeaponryType type) {
        return weaponryInMilitaryBaseDAO.findAllByCorpsAndWeaponryType(id, type);
    }
}
