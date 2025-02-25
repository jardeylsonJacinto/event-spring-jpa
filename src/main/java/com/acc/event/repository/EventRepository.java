package com.acc.event.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acc.event.model.Evento;

import jakarta.transaction.Transactional;

public interface EventRepository extends JpaRepository<Evento, Long> {
  List<Evento> findByLocalId(Long localId);

  @Transactional
  void deleteByLocalId(Long localId);
}
