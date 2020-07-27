package com.novellius.test;

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
import com.novellius.domain.Tramite;
import com.novellius.domain.Tramite_;
import com.novellius.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			// Consulta del trámite de un avalúo
			Avaluo avaluo = session.load(Avaluo.class, 2);
			Tramite tramite = avaluo.getTramite();
			System.out.println("Tramite del avalúo 2: " + tramite);
			
			// Todos los trámites que aparecen en avalúos
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Avaluo> criteria = builder.createQuery(Avaluo.class);
			Root<Avaluo> root = criteria.from(Avaluo.class);
			criteria.select(root);
			
			List<Avaluo> avaluos = session.createQuery(criteria).getResultList();
			System.out.println("Todos los trámites contenidos en avalúos...");
			for(Avaluo avaluo2 : avaluos){
				System.out.println(avaluo2);
			}
			
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
