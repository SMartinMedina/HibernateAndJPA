package com.novellius.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.novellius.domain.Avaluo;
import com.novellius.domain.Avaluo_;
import com.novellius.domain.DiarioCliente;
import com.novellius.domain.DiarioCliente_;
import com.novellius.domain.Imagen;
import com.novellius.domain.Imagen_;
import com.novellius.domain.Inmueble;
import com.novellius.domain.Inmueble_;
import com.novellius.domain.Tramite;
import com.novellius.domain.Tramite_;
import com.novellius.service.InmuebleService;
import com.novellius.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		InmuebleService inmuebleService = new InmuebleService(session);
		
		inmuebleService.save(new Inmueble("casa", "morelos #100"), null);

		List<Imagen> imagenes = new ArrayList<>();
		imagenes.add(new Imagen("www...", new Timestamp(new Date().getTime())));
		imagenes.add(new Imagen("http...", new Timestamp(new Date().getTime())));
		imagenes.add(new Imagen("https....", new Timestamp(new Date().getTime())));
		
		inmuebleService.save(new Inmueble("terreno", "hidalgo #600"), imagenes);
		inmuebleService.closeSession();
		

	}

}
