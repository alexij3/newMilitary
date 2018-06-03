package com.vyshyvan.repositories.officers;

import com.vyshyvan.model.Officers;
import com.vyshyvan.model.Rang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficersDAO extends JpaRepository<Officers, Integer> {
    List<Officers> findAllByRang(@Param("rang") Rang rang);

    @Query("SELECT o FROM Officers o WHERE o.rang = :rang AND o.soldier.militaryBase.id = :id")
    List<Officers> findAllByRangAndSoldierMilitaryBase_Id(@Param("rang") Rang rang, @Param("id") int id);

    @Query("SELECT o FROM Officers o JOIN o.soldier s JOIN s.militaryBase d WHERE o.rang = :rang AND d.division.id = :id")
    List<Officers> findAllByRangAndDivisionId(@Param("rang") Rang rang, @Param("id") int id);

    @Query("SELECT o FROM Officers o JOIN o.soldier s JOIN s.militaryBase d WHERE o.rang = :rang AND d.army.id = :id")
    List<Officers> findAllByRangAndArmyId(@Param("rang") Rang rang, @Param("id") int id);
}
