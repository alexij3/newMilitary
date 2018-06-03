package com.vyshyvan.services.platoon;

import com.vyshyvan.model.Platoon;
import com.vyshyvan.repositories.platoon.PlatoonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoonServiceImpl implements PlatoonService {
    @Autowired
    PlatoonDAO platoonDAO;

    @Override
    public Platoon insertPlatoon(Platoon platoon) {
        return platoonDAO.save(platoon);
    }

    @Override
    public Platoon getPlatoon(int id) {
        return platoonDAO.findById(id).get();
    }

    @Override
    public Platoon updatePlatoon(Platoon platoon) {
        return platoonDAO.save(platoon);
    }

    @Override
    public void deletePlatoon(int id) {
        platoonDAO.deleteById(id);
    }

    @Override
    public List<Platoon> getAll() {
        return (List<Platoon>) platoonDAO.findAll();
    }
}
