package com.vyshyvan.services.dislocation;

import com.vyshyvan.model.MilitaryBaseDislocation;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MilitaryBaseDislocationService {
    MilitaryBaseDislocation insert(MilitaryBaseDislocation militaryBaseDislocation);
    MilitaryBaseDislocation get(int id);
    MilitaryBaseDislocation update(MilitaryBaseDislocation militaryBaseDislocation);
    void delete(int id);
    List<MilitaryBaseDislocation> getAll();

    List<MilitaryBaseDislocation> findAllByMilitaryBaseId(int id);
    List<MilitaryBaseDislocation> findAllByMilitaryBaseArmy_Id(long id);
    List<MilitaryBaseDislocation> findAllByMilitaryBaseDivision_Id(int id);
    List<MilitaryBaseDislocation> findAllByMilitaryBaseCorps_Id(int id);
}
