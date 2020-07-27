package com.novellius.service;

import java.util.List;

import org.hibernate.Session;

import com.novellius.dao.InmuebleDaoImpl;
import com.novellius.domain.Imagen;
import com.novellius.domain.Inmueble;

public class InmuebleService {
	
	private InmuebleDaoImpl inmuebleDao;

	public InmuebleService(Session session) {
		inmuebleDao = new InmuebleDaoImpl(session);
	}
	
	public Inmueble findById(int id){
		return inmuebleDao.findById(id);
	}
	
	public void save(Inmueble inmueble, List<Imagen> imagenes) {
		if(imagenes != null){
			for(Imagen imagen : imagenes){
				inmueble.getImagenes().add(imagen);
			}
		}
		inmuebleDao.save(inmueble);
	}

	public void closeSession(){
		inmuebleDao.closeSession();
	}
}
