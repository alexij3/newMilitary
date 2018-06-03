package com.vyshyvan.repositories.militarybase;

import com.vyshyvan.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MilitaryBaseDAO extends JpaRepository<MilitaryBase, Integer> {
    List<MilitaryBase> findAllByArmyId(@Param("id") int id);

    @Query("SELECT a FROM MilitaryBase a WHERE a.division.id = :id")
    List<MilitaryBase> findAllByDivisionId(@Param("id") int id);

    @Query("SELECT a FROM MilitaryBase a WHERE a.corps.id = :id")
    List<MilitaryBase> findAllByCorpsId(@Param("id") int id);

}

