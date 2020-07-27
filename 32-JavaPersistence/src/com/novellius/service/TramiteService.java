package com.novellius.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.novellius.domain.Tramite;
import com.novellius.repository.TramiteRepository;

@Service
public class TramiteService {
	
	private static final int ITEMS_PER_PAGE = 6;
	
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
	
	public List<Tramite> findByTipoTramLike(String tipoTram){
		return (List<Tramite>) tramiteRepository.findByTipoTramLike("%" + tipoTram + "%");
	}
	
	public List<Tramite> findByFhcTramLessThan(String stringDate){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(stringDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (List<Tramite>) tramiteRepository.findByFhcTramLessThan(new Timestamp(parsedDate.getTime()));
	}
	
	@Transactional
	public Integer deleteByTipoTram(String tipoTram){
		return tramiteRepository.deleteByTipoTram(tipoTram);
	}
	
	public Page<Tramite> findAll(int index){
		return tramiteRepository.findAll(new PageRequest(index, ITEMS_PER_PAGE, Direction.ASC, "idTram"));
	}
	
	public Page<Tramite> findByTipoTramLike(int index, String tipoTram){
		return tramiteRepository.findByTipoTramLike(tipoTram, new PageRequest(index, ITEMS_PER_PAGE, Direction.ASC, "idTram"));
	}

}
