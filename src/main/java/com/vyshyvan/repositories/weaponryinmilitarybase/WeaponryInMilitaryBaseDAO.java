package com.vyshyvan.repositories.weaponryinmilitarybase;

import com.vyshyvan.model.WeaponryInMilitaryBase;
import com.vyshyvan.model.WeaponryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeaponryInMilitaryBaseDAO extends JpaRepository<WeaponryInMilitaryBase, Integer> {
    @Query("SELECT a FROM WeaponryInMilitaryBase a WHERE a.weaponry.weaponryType = :type")
    List<WeaponryInMilitaryBase> findAllByWeaponryType(@Param("type") WeaponryType type);

    @Query("SELECT a FROM WeaponryInMilitaryBase a WHERE a.militaryBase.id = :id AND a.weaponry.weaponryType = :type")
    List<WeaponryInMilitaryBase> findAllByBaseAndWeaponryType(@Param("id") int id, @Param("type") WeaponryType type);

    @Query("SELECT a FROM WeaponryInMilitaryBase a WHERE a.militaryBase.army.id = :id AND a.weaponry.weaponryType = :type")
    List<WeaponryInMilitaryBase> findAllByArmyAndWeaponryType(@Param("id") long id, @Param("type") WeaponryType type);

    @Query("SELECT a FROM WeaponryInMilitaryBase a WHERE a.militaryBase.division.id = :id AND a.weaponry.weaponryType = :type")
    List<WeaponryInMilitaryBase> findAllByDivisionAndWeaponryType(@Param("id") int id, @Param("type") WeaponryType type);

    @Query("SELECT a FROM WeaponryInMilitaryBase a WHERE a.militaryBase.corps.id = :id AND a.weaponry.weaponryType = :type")
    List<WeaponryInMilitaryBase> findAllByCorpsAndWeaponryType(@Param("id") int id, @Param("type") WeaponryType type);
}

