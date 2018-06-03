package com.vyshyvan.repositories.brigade;

import com.vyshyvan.model.Brigade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrigadeDAO extends JpaRepository<Brigade, Integer> {

}
