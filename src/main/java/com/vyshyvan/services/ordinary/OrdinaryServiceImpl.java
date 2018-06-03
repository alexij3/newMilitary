package com.vyshyvan.services.ordinary;

import com.vyshyvan.model.Ordinary;
import com.vyshyvan.model.Rang;
import com.vyshyvan.repositories.ordinary.OrdinaryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdinaryServiceImpl implements OrdinaryService{
    @Autowired
    OrdinaryDAO ordinaryDAO;

    @Override
    public Ordinary insertOrdinary(Ordinary ordinary) {
        return ordinaryDAO.save(ordinary);
    }

    @Override
    public Ordinary getOrdinary(int id) {
        return ordinaryDAO.findById(id).get();
    }

    @Override
    public Ordinary updateOrdinary(Ordinary ordinary) {
        return ordinaryDAO.save(ordinary);
    }

    @Override
    public void deleteOrdinary(int id) {
        ordinaryDAO.deleteById(id);
    }

    @Override
    public List<Ordinary> getAll() {
        return (List<Ordinary>) ordinaryDAO.findAll();
    }

    @Override
    public List<Ordinary> findAllByRang(Rang rang) {
        return ordinaryDAO.findAllByRang(rang);
    }

    @Override
    public List<Ordinary> findAllByRangAndSoldierMilitaryBase_Id(Rang rang, int id) {
        return ordinaryDAO.findAllByRangAndSoldierMilitaryBase_Id(rang, id);
    }

    @Override
    public List<Ordinary> findAllByRangAndDivisionId(Rang rang, int id) {
        return ordinaryDAO.findAllByRangAndDivisionId(rang, id);
    }

    @Override
    public List<Ordinary> findAllByRangAndArmyId(Rang rang, int id) {
        return ordinaryDAO.findAllByRangAndArmyId(rang, id);
    }
}
