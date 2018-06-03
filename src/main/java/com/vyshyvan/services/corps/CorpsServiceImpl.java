package com.vyshyvan.services.corps;

import com.vyshyvan.model.Corps;
import com.vyshyvan.repositories.corps.CorpsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorpsServiceImpl implements CorpsService{
    @Autowired
    CorpsDAO corpsDAO;

    @Override
    public Corps insertCorps(Corps corps) {
        return corpsDAO.save(corps);
    }

    @Override
    public Corps getCorps(int id) {
        return corpsDAO.findById(id).get();
    }

    @Override
    public Corps updateCorps(Corps corps) {
        return corpsDAO.save(corps);
    }

    @Override
    public void deleteCorps(int id) {
        corpsDAO.deleteById(id);
    }

    @Override
    public List<Corps> getAll() {
        return (List<Corps>) corpsDAO.findAll();
    }
}
