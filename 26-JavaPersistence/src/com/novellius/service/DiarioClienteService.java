package com.novellius.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novellius.domain.DiarioCliente;
import com.novellius.domain.Tramite;
import com.novellius.repository.DiarioClienteRepository;

@Service
public class DiarioClienteService {

	@Autowired
	private DiarioClienteRepository diarioClienteRepo;
	
	public List<DiarioCliente> findByTramite(Tramite tramite){
		return diarioClienteRepo.findByTramite(tramite);
	}
}
