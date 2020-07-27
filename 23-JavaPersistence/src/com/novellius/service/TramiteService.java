package com.novellius.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novellius.domain.Tramite;
import com.novellius.repository.TramiteRepository;

@Service
public class TramiteService {
	
	@Autowired
	private TramiteRepository tramiteRepository;
	
	public void save(Tramite tramite){
		tramiteRepository.save(tramite);
	}

}
