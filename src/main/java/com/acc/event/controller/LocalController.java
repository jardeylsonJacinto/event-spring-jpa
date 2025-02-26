package com.acc.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acc.event.model.Local;
import com.acc.event.service.LocalService;

@RestController
public class LocalController {
  @Autowired
  LocalService localService;

  @GetMapping("/local")
  private List<Local> getAllLocal() {
    return localService.getAllLocal();
  }

  @GetMapping("/local/{id}")
  private Local getLocal(@PathVariable("id") int id) {
    return localService.getLocalById(id);
  }

  @DeleteMapping("/local/{id}")
  private void deleteLocal(@PathVariable("id") int id) {
    localService.delete(id);
  }

  @PostMapping("/local")
  private long saveLocal(@RequestBody Local local) {
    localService.saveOrUpdate(local);
    return local.getId();
  }
}