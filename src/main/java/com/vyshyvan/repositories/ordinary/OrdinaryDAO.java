package com.vyshyvan.repositories.ordinary;

import com.vyshyvan.model.Ordinary;
import com.vyshyvan.model.Rang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdinaryDAO extends JpaRepository<Ordinary, Integer> {
    List<Ordinary> findAllByRang(@Param("rang") Rang rang);

    @Query("SELECT o FROM Ordinary o WHERE o.rang = :rang AND o.soldier.militaryBase.id = :id")
    List<Ordinary> findAllByRangAndSoldierMilitaryBase_Id(@Param("rang") Rang rang, @Param("id") int id);

    @Query("SELECT o FROM Ordinary o JOIN o.soldier s JOIN s.militaryBase d WHERE o.rang = :rang AND d.division.id = :id")
    List<Ordinary> findAllByRangAndDivisionId(@Param("rang") Rang rang, @Param("id") int id);

    @Query("SELECT o FROM Ordinary o JOIN o.soldier s JOIN s.militaryBase d WHERE o.rang = :rang AND d.army.id = :id")
    List<Ordinary> findAllByRangAndArmyId(@Param("rang") Rang rang, @Param("id") int id);
}
