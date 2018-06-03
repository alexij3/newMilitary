package com.vyshyvan.repositories.transportinmilitarybase;

import com.vyshyvan.model.TransportInMilitaryBase;
import com.vyshyvan.model.TransportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportInMilitaryBaseDAO extends JpaRepository<TransportInMilitaryBase, Integer> {

    @Query("SELECT a FROM TransportInMilitaryBase a WHERE a.transport.transportType = :type")
    List<TransportInMilitaryBase> findAllByTransportType(@Param("type") TransportType type);

    @Query("SELECT a FROM TransportInMilitaryBase a WHERE a.militaryBase.id = :id AND a.transport.transportType = :type")
    List<TransportInMilitaryBase> findAllByBaseAndTransportType(@Param("id") int id, @Param("type") TransportType type);

    @Query("SELECT a FROM TransportInMilitaryBase a WHERE a.militaryBase.army.id = :id AND a.transport.transportType = :type")
    List<TransportInMilitaryBase> findAllByArmyAndTransportType(@Param("id") long id, @Param("type") TransportType type);

    @Query("SELECT a FROM TransportInMilitaryBase a WHERE a.militaryBase.division.id = :id AND a.transport.transportType = :type")
    List<TransportInMilitaryBase> findAllByDivisionAndTransportType(@Param("id") int id, @Param("type") TransportType type);

    @Query("SELECT a FROM TransportInMilitaryBase a WHERE a.militaryBase.corps.id = :id AND a.transport.transportType = :type")
    List<TransportInMilitaryBase> findAllByCorpsAndTransportType(@Param("id") int id, @Param("type") TransportType type);
}

