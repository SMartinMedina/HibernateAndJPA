package com.novellius.repository;

import org.springframework.data.repository.CrudRepository;

import com.novellius.domain.Tramite;

public interface TramiteRepository extends CrudRepository<Tramite, Integer>{
	// NO NECESITA IMPLEMENTAR LOS MÉTODOS CRUD
}
