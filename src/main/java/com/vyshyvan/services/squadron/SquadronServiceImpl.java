package com.vyshyvan.services.squadron;

import com.vyshyvan.model.Squadron;
import com.vyshyvan.repositories.squadron.SquadronDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SquadronServiceImpl implements SquadronService {
    @Autowired
    SquadronDAO squadronDAO;

    @Override
    public Squadron insertSquadron(Squadron squadron) {
        return squadronDAO.save(squadron);
    }

    @Override
    public Squadron getSquadron(int id) {
        return squadronDAO.findById(id).get();
    }

    @Override
    public Squadron updateSquadron(Squadron squadron) {
        return squadronDAO.save(squadron);
    }

    @Override
    public void deleteSquadron(int id) {
        squadronDAO.deleteById(id);
    }

    @Override
    public List<Squadron> getAll() {
        return (List<Squadron>) squadronDAO.findAll();
    }
}
