package com.vyshyvan.repositories.weaponry;

import com.vyshyvan.model.Weaponry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponryDAO extends JpaRepository<Weaponry, Integer> {

}

