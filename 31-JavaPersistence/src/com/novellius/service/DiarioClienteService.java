package com.novellius.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
//		QTramite tramite = QTramite.tramite;
//		QDiarioCliente diarioCliente = QDiarioCliente.diarioCliente;
//		
//		return new JPAQuery(entityManager)
//				.from(tramite)
//				.join(tramite.diarioClienteSet, diarioCliente)
//				.where(tramite.tipoTram.eq(tipoTram))
//				.list(diarioCliente);
		
		return diarioClienteRepo.findByTramite_TipoTram(tipoTram);
	}
	
	public List<DiarioCliente> findByTipoTramAndFhcTram(String tipoTram){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date parsedDate = null;
		try{
			parsedDate = dateFormat.parse("2017-05-01 14:11:30");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Timestamp timestamp = new Timestamp(parsedDate.getTime());
		
		return diarioClienteRepo.findByTramite_TipoTramAndTramite_FhcTramLessThan(tipoTram, timestamp);
	}
}
