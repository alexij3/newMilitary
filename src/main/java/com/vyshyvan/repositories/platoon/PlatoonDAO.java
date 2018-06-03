package com.vyshyvan.repositories.platoon;

import com.vyshyvan.model.Platoon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoonDAO extends JpaRepository<Platoon, Integer> {

}
