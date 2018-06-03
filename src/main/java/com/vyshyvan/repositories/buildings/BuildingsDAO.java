package com.vyshyvan.repositories.buildings;

import com.vyshyvan.model.Buildings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingsDAO extends JpaRepository<Buildings, Integer> {
    @Query(value = "SELECT id, name FROM\n" +
            "(SELECT buildings.id, buildings.name, COUNT(dislocation) as c FROM base_dislocation\n" +
            "JOIN buildings ON dislocation = buildings.id\n" +
            "GROUP BY buildings.id) as temp_table WHERE c > 1", nativeQuery = true)
    List<Buildings> findAllByMoreThanOneUnit();

    @Query(value = "SELECT id, name FROM buildings\n" +
            "WHERE buildings.id NOT IN (SELECT dislocation FROM base_dislocation);", nativeQuery = true)
    List<Buildings> findAllByNoUnits();
}
