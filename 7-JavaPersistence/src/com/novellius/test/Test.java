package com.novellius.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.novellius.domain.Tramite;
import com.novellius.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		

		// Fábrica para las piezas individuales de la criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
		
		// Definir el tipo de entidad que retorna la consulta
		Root<Tramite> root = criteria.from(Tramite.class);
		
		// Construyendo la consulta
		criteria.select(root);

		List<Tramite> tramites = session.createQuery(criteria).getResultList();
		
		System.out.println(tramites.toString());
		
		
		
		session.getTransaction().commit();
		session.close();

	}

}
