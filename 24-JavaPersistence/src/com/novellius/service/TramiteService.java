package com.novellius.service;

import java.util.List;

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
	
	public void save(List<Tramite> tramites){
		tramiteRepository.save(tramites);
	}
	
	public Tramite findOne(int id){
		return tramiteRepository.findOne(id);
	}
	
	public List<Tramite> findAll(){
		return (List<Tramite>) tramiteRepository.findAll();
	}
	
	public boolean exists(int id){
		return tramiteRepository.exists(id);
	}
	

}
