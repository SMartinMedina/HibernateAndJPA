package com.novellius.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.novellius.domain.Tramite;
import com.novellius.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		Date date = new Date();
//		// Crear una instancia de Tramite
//		Tramite tramite = new Tramite("Crédito", new Timestamp(date.getTime()));
//		// Salvar el tramite 
//		session.save(tramite);	// INSERT INTO Tramite...
		
		@SuppressWarnings("unchecked")
		Query<Tramite> query = session.createQuery("from Tramite where tipoTram = :tipoTram"); 
		query.setParameter("tipoTram", "Crédito");
		
		List<Tramite> tramites = query.getResultList();
		System.out.println(tramites.toString());
		
		
		
		session.getTransaction().commit();
		session.close();

	}

}
