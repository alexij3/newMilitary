package com.vyshyvan.repositories.squadron;

import com.vyshyvan.model.Squadron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquadronDAO extends JpaRepository<Squadron, Integer> {

}

