package com.novellius.dao;

import java.util.List;

import com.novellius.domain.Imagen;
import com.novellius.domain.Inmueble;

public interface InmuebleDao {
	
	public void save(Inmueble inmueble);
	public List<Imagen> findAll(Inmueble inmueble);
	public Inmueble findById(int id);

}
