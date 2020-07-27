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
import com.novellius.domain.Imagen;
import com.novellius.domain.Imagen_;
import com.novellius.domain.Inmueble;
import com.novellius.domain.Inmueble_;
import com.novellius.domain.Tramite;
import com.novellius.domain.Tramite_;
import com.novellius.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			// Consultar las imagenes de un inmueble
//			CriteriaBuilder builder = session.getCriteriaBuilder();
//			CriteriaQuery<Imagen> criteria = builder.createQuery(Imagen.class);
//			Root<Imagen> root = criteria.from(Imagen.class);
//			
//			Join<Imagen, Inmueble> join = root.join(Imagen_.inmuebles);
//			
//			criteria.where(
//					builder.and(
//							builder.equal(join.get(Inmueble_.idInm), 1),
//							builder.like(root.get(Imagen_.urlImg), "%drive%")
//							)
//					);
			
			// Consultar inmuebles asociados a una imagen
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Inmueble> criteria = builder.createQuery(Inmueble.class);
			Root<Inmueble> root = criteria.from(Inmueble.class);
			
			Join<Inmueble, Imagen> join = root.join(Inmueble_.imagenes);
			
			
			criteria.where(
					builder.and(
							builder.equal(join.get(Imagen_.idImg), 1),
							builder.equal(root.get(Inmueble_.tipoInm), "terreno")
							)
					
							
					);
			
			
			
			List<Inmueble> results = session.createQuery(criteria).getResultList();
			System.out.println("resultados: " + results.size());
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
