package com.acc.event.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.event.model.Local;
import com.acc.event.repository.LocalRepository;

@Service
public class LocalService {
  @Autowired
  LocalRepository localRepository;

  public List<Local> getAllLocal() {
    List<Local> locais = new ArrayList<Local>();
    localRepository.findAll().forEach(local -> locais.add(local));
    return locais;
  }

  public Local getLocalById(long id) {
    return localRepository.findById(id).get();
  }

  public void saveOrUpdate(Local local) {
    localRepository.save(local);
  }

  public void delete(long id) {
    localRepository.deleteById(id);
  }
}
