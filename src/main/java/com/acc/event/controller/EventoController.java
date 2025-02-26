package com.acc.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acc.event.model.Evento;
import com.acc.event.service.EventoService;

@RestController
@RequestMapping("/api")
public class EventoController {

	@Autowired
	private EventoService eventoService;

	@GetMapping("/eventos")
	public List<Evento> getAllEventos() {
		return eventoService.getAllEventos();
	}

	@GetMapping("/evento/{id}")
	public ResponseEntity<Evento> getEvento(@PathVariable("id") int id) {
		Evento evento = eventoService.getEventoById(id);
		return ResponseEntity.ok(evento);
	}

	@DeleteMapping("/evento/{id}")
	public ResponseEntity<HttpStatus> deleteEvento(@PathVariable("id") int id) {
		eventoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/evento")
	public ResponseEntity<Evento> saveEvento(@RequestBody Evento evento) {
		eventoService.saveOrUpdate(evento);
		return new ResponseEntity<>(evento, HttpStatus.CREATED);
	}

	@PostMapping("/local/{localId}/evento")
	public ResponseEntity<Evento> criarEvento(@PathVariable("localId") Long localId,
			@RequestBody Evento eventoRequest) {
		Evento eventoCriado = eventoService.criarEvento(localId, eventoRequest);
		return new ResponseEntity<>(eventoCriado, HttpStatus.CREATED);
	}

	@GetMapping("/local/{localId}/evento")
	public ResponseEntity<List<Evento>> consultaEventosPorLocalId(@PathVariable("localId") Long localId) {
		List<Evento> eventos = eventoService.consultaEventosPorLocalId(localId);
		return new ResponseEntity<>(eventos, HttpStatus.OK);
	}

	@DeleteMapping("/local/{localId}/evento")
	public ResponseEntity<HttpStatus> deletaEventosPorLocalId(@PathVariable("localId") Long localId) {
		eventoService.deletaEventosPorLocalId(localId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
