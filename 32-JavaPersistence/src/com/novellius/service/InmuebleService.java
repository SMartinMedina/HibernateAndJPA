package com.novellius.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novellius.domain.Inmueble;
import com.novellius.repository.InmuebleRepository;

@Service
public class InmuebleService {

	@Autowired
	private InmuebleRepository inmuebleRepository;
	
	
	public void save(Inmueble inmueble){
		inmuebleRepository.save(inmueble);
	}
}
