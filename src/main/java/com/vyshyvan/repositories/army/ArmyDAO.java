package com.vyshyvan.repositories.army;

import com.vyshyvan.model.Army;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import java.util.List;

@Repository
public interface ArmyDAO extends JpaRepository<Army, Long> {
    @Query(value = "SELECT army_id as id, army.name, army.code_number, bases FROM(SELECT army_id, COUNT(army_id) as bases FROM military_base GROUP BY army_id) T JOIN army ON army_id = army.id WHERE bases = (SELECT MAX(bases) FROM(SELECT army_id, COUNT(army_id) as bases FROM military_base GROUP BY army_id) B);", nativeQuery = true)
    List<Army> findArmyByMaxBases();

    @Query(value = "SELECT army_id as id, army.name, army.code_number, bases FROM(SELECT army_id, COUNT(army_id) as bases FROM military_base GROUP BY army_id) T JOIN army ON army_id = army.id WHERE bases = (SELECT MIN(bases) FROM(SELECT army_id, COUNT(army_id) as bases FROM military_base GROUP BY army_id) B);", nativeQuery = true)
    List<Army> findArmyByMinBases();
}
