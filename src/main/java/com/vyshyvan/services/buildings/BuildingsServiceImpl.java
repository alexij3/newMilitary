package com.vyshyvan.services.buildings;

import com.vyshyvan.repositories.buildings.BuildingsDAO;
import com.vyshyvan.model.Buildings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingsServiceImpl implements BuildingsService {
    @Autowired
    BuildingsDAO buildingsDAO;

    @Override
    public Buildings insertBuildings(Buildings buildings) {
        return buildingsDAO.save(buildings);
    }

    @Override
    public Buildings getBuildings(int id) {
        return buildingsDAO.findById(id).get();
    }

    @Override
    public Buildings updateBuildings(Buildings buildings) {
        return buildingsDAO.save(buildings);
    }

    @Override
    public void deleteBuildings(int id) { buildingsDAO.deleteById(id);
    }

    @Override
    public List<Buildings> getAll() {
        return (List<Buildings>) buildingsDAO.findAll();
    }

    @Override
    public List<Buildings> findAllByMoreThanOneUnit() {
        return buildingsDAO.findAllByMoreThanOneUnit();
    }

    @Override
    public List<Buildings> findAllByNoUnits() {
        return buildingsDAO.findAllByNoUnits();
    }
}