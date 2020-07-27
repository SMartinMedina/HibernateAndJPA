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
import com.novellius.domain.DiarioCliente_;
import com.novellius.domain.Tramite;
import com.novellius.domain.Tramite_;
import com.novellius.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			// Consultar todos los trámites que se encuentran en DiarioCliente
//			CriteriaBuilder builder = session.getCriteriaBuilder();
//			CriteriaQuery<Tramite> criteria = builder.createQuery( Tramite.class );
//			Root<Tramite> root = criteria.from( Tramite.class );
//			
//			Join<Tramite, DiarioCliente> join = root.join(Tramite_.diarioClienteSet);
//
//			criteria.select(root).distinct(true);
			
			// Consultar todos los diarios de un trámite
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<DiarioCliente> criteria = builder.createQuery( DiarioCliente.class );
			Root<DiarioCliente> root = criteria.from( DiarioCliente.class );
			
			Join<DiarioCliente, Tramite> join = root.join(DiarioCliente_.tramite);
			
			criteria.where(
					builder.equal(root.get(DiarioCliente_.tramite), session.load(Tramite.class, 1))
					);
			
			List<DiarioCliente> results = session.createQuery(criteria).getResultList();
			System.out.println("Resultados: " + results.size());
			System.out.println(results);
			
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
