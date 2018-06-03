package com.vyshyvan.repositories.militarybasedislocation;

import com.vyshyvan.model.MilitaryBaseDislocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MilitaryBaseDislocationRepository extends JpaRepository<MilitaryBaseDislocation, Integer> {
    List<MilitaryBaseDislocation> findAllByMilitaryBaseId(@Param("id") int id);

    @Query("SELECT a FROM MilitaryBaseDislocation a WHERE a.militaryBase.army.id = :id")
    List<MilitaryBaseDislocation> findAllByMilitaryBaseArmy_Id(@Param("id") long id);

    @Query("SELECT a FROM MilitaryBaseDislocation a WHERE a.militaryBase.division.id = :id")
    List<MilitaryBaseDislocation> findAllByMilitaryBaseDivision_Id(@Param("id") int id);

    @Query("SELECT a FROM MilitaryBaseDislocation a WHERE a.militaryBase.corps.id = :id")
    List<MilitaryBaseDislocation> findAllByMilitaryBaseCorps_Id(@Param("id") int id);

}
