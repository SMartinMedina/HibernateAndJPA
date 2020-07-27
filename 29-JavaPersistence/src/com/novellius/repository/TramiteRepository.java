package com.novellius.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.novellius.domain.Tramite;

public interface TramiteRepository extends CrudRepository<Tramite, Integer>{
	// NO NECESITA IMPLEMENTAR LOS MÉTODOS CRUD
	
	// SELECT * FROM Tramite WHERE tipoTram LIKE ...
	public List<Tramite> findByTipoTramLike(String tipoTram);
	
	public List<Tramite> findByFhcTramLessThan(Timestamp date);
	
	public Integer deleteByTipoTram(String tipoTram);
	
	public Page<Tramite> findAll(Pageable pageable);
	
}
