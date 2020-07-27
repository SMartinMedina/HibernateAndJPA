package com.novellius.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import com.novellius.domain.Tramite;
import com.novellius.domain.Tramite_;
import com.novellius.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Timestamp time = new Timestamp(new Date().getTime());
			
			Tramite tramite = new Tramite("Ampliación", time);
			Tramite tramite2 = new Tramite("Crédito", time);
			session.save(tramite);
			session.save(tramite2);
			
			DiarioCliente diarioCliente = new DiarioCliente("Entrada 1", time);
			DiarioCliente diarioCliente2 = new DiarioCliente("Entrada 2", time);
			DiarioCliente diarioCliente3 = new DiarioCliente("Entrada 3", time);
			
			diarioCliente.setTramite(tramite);
			diarioCliente2.setTramite(tramite);
			diarioCliente3.setTramite(tramite2);
			
			session.save(diarioCliente);
			session.save(diarioCliente2);
			session.save(diarioCliente3);
			
			Tramite tramite4 = session.load(Tramite.class, 2);
			DiarioCliente diarioCliente4 = new DiarioCliente("Nueva Entrada 1", time);
			diarioCliente4.setTramite(tramite4);
			
			session.save(diarioCliente4);
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		

		
		
		
		

	}

}
