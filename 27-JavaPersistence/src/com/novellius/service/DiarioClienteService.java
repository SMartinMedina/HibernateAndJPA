package com.novellius.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.novellius.domain.DiarioCliente;
import com.novellius.domain.QDiarioCliente;
import com.novellius.domain.QTramite;
import com.novellius.domain.Tramite;
import com.novellius.repository.DiarioClienteRepository;

@Service
public class DiarioClienteService {

	@Autowired
	private DiarioClienteRepository diarioClienteRepo;
	
	@Autowired
	private EntityManager entityManager;
	
	
	public List<DiarioCliente> findByTramite(Tramite tramite){
		return diarioClienteRepo.findByTramite(tramite);
	}
	
	
	public List<DiarioCliente> findByTipoTram(String tipoTram){
		QTramite tramite = QTramite.tramite;
		QDiarioCliente diarioCliente = QDiarioCliente.diarioCliente;
		
		return new JPAQuery(entityManager)
				.from(tramite)
				.join(tramite.diarioClienteSet, diarioCliente)
				.where(tramite.tipoTram.eq(tipoTram))
				.list(diarioCliente);
	}
}
