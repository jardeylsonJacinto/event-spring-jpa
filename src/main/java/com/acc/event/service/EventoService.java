package com.acc.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.acc.event.model.Evento;
import com.acc.event.repository.EventoRepository;
import com.acc.event.repository.LocalRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoRepository;

	@Autowired
	private LocalRepository localRepository;

	public List<Evento> getAllEventos() {
		return eventoRepository.findAll();
	}

	public Evento getEventoById(long id) {
		return eventoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento não encontrado com id = " + id));
	}

	public void saveOrUpdate(Evento evento) {
		eventoRepository.save(evento);
	}

	public void delete(long id) {
		eventoRepository.deleteById(id);
	}

	// POST Adicionar um Evento a um Local
	public Evento createEvento(Long localId, Evento eventoRequest) {
		return localRepository.findById(localId)
				.map(local -> {
					eventoRequest.setLocal(local);
					return eventoRepository.save(eventoRequest);
				})
				.orElseThrow(
						() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Local não encontrado com id = " + localId));
	}

	// GET Consultar Eventos por Local
	public List<Evento> consultaEventosPorLocalId(Long localId) {
		if (!localRepository.existsById(localId)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Local não encontrado com id = " + localId);
		}
		return eventoRepository.findByLocalId(localId);
	}

	// DELETE Eventos por Local
	public void deletaEventosPorLocalId(Long localId) {
		if (!localRepository.existsById(localId)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Local não encontrado com id = " + localId);
		}
		eventoRepository.deleteByLocalId(localId);
	}
}
