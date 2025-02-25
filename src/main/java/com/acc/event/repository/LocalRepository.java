package com.acc.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acc.event.model.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {

}
