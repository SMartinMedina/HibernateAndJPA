package com.novellius.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;

import com.novellius.domain.Tramite;
import com.novellius.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		
		// Crear una instancia de Tramite
		Tramite tramite = new Tramite("Crédito rechazado", new Timestamp(date.getTime()));
		
		// Salvar el tramite 
		session.save(tramite);	// insert into Tramite (tipoTram, fhcTram) values (?, ?)
		
		
		
		session.getTransaction().commit();
		session.close();

	}

}
