package com.vyshyvan.repositories.division;

import com.vyshyvan.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DivisionDAO extends JpaRepository<Division, Integer> {

    @Query(value = "SELECT division_id as id, division.name, division.code_number, bases FROM( SELECT division_id, COUNT(division_id) as bases FROM military_base GROUP BY division_id) T JOIN division ON division_id = division.id WHERE bases = (SELECT MAX(bases) FROM(SELECT division_id, COUNT(division_id) as bases FROM military_base GROUP BY division_id) B);", nativeQuery = true)
    List<Division> findByMaxBases();

    @Query(value = "SELECT division_id as id, division.name, division.code_number, bases FROM( SELECT division_id, COUNT(division_id) as bases FROM military_base GROUP BY division_id) T JOIN division ON division_id = division.id WHERE bases = (SELECT MIN(bases) FROM(SELECT division_id, COUNT(division_id) as bases FROM military_base WHERE division_id IS NOT NULL GROUP BY division_id) B);", nativeQuery = true)
    List<Division> findByMinBases();
}

