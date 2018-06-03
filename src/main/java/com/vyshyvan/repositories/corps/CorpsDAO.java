package com.vyshyvan.repositories.corps;

import com.vyshyvan.model.Corps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorpsDAO extends JpaRepository<Corps, Integer> {

    @Query(value = "SELECT corps_id as id, corps.name, corps.code_number, bases FROM( SELECT corps_id, COUNT(corps_id) as bases FROM military_base GROUP BY corps_id) T JOIN corps ON corps_id = corps.id WHERE bases = (SELECT MAX(bases) FROM(SELECT corps_id, COUNT(corps_id) as bases FROM military_base GROUP BY corps_id) B);", nativeQuery = true)
    List<Corps> findByMaxBases();

    @Query(value = "SELECT corps_id as id, corps.name, corps.code_number, bases FROM(SELECT corps_id, COUNT(corps_id) as bases FROM military_base GROUP BY corps_id) T JOIN corps ON corps_id = corps.id WHERE bases = (SELECT MIN(bases) FROM(SELECT corps_id, COUNT(corps_id) as bases FROM military_base WHERE corps_id IS NOT NULL GROUP BY corps_id) B);", nativeQuery = true)
    List<Corps> findByMinBases();

}

