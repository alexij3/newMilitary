package com.vyshyvan.services.dislocation;

import com.vyshyvan.model.MilitaryBaseDislocation;
import com.vyshyvan.repositories.militarybasedislocation.MilitaryBaseDislocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilitaryBaseDislocationServiceImpl implements MilitaryBaseDislocationService {
    @Autowired
    MilitaryBaseDislocationRepository repository;

    @Override
    public MilitaryBaseDislocation insert(MilitaryBaseDislocation militaryBaseDislocation) {
        return repository.save(militaryBaseDislocation);
    }

    @Override
    public MilitaryBaseDislocation get(int id) {
        return repository.findById(id).get();
    }

    @Override
    public MilitaryBaseDislocation update(MilitaryBaseDislocation militaryBaseDislocation) {
        return repository.save(militaryBaseDislocation);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<MilitaryBaseDislocation> getAll() {
        return repository.findAll();
    }

    @Override
    public List<MilitaryBaseDislocation> findAllByMilitaryBaseId(int id) {
        return repository.findAllByMilitaryBaseId(id);
    }

    @Override
    public List<MilitaryBaseDislocation> findAllByMilitaryBaseArmy_Id(long id) {
        return repository.findAllByMilitaryBaseArmy_Id(id);
    }

    @Override
    public List<MilitaryBaseDislocation> findAllByMilitaryBaseDivision_Id(int id) {
        return repository.findAllByMilitaryBaseDivision_Id(id);
    }

    @Override
    public List<MilitaryBaseDislocation> findAllByMilitaryBaseCorps_Id(int id) {
        return repository.findAllByMilitaryBaseCorps_Id(id);
    }
}
