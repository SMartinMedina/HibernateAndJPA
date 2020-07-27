package com.novellius.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.novellius.domain.DiarioCliente;
import com.novellius.domain.Tramite;

public interface DiarioClienteRepository extends CrudRepository<DiarioCliente, Integer>{
	
	public List<DiarioCliente> findByTramite(Tramite tramite);
	
	public List<DiarioCliente> findByTramite_TipoTram(String tipoTram);
	
	public List<DiarioCliente> findByTramite_TipoTramAndTramite_FhcTramLessThan(String tipoTram, Timestamp fhcTram);

}
