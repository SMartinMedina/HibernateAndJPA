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
			
			// Actualizar imagen1 del inmueble1
//			Inmueble inmueble1 = session.load(Inmueble.class, 1);
//			Imagen imagen1 = session.load(Imagen.class, 1);
//			
//			inmueble1.getImagenes().remove(imagen1);
//			imagen1.setUrlImg("www.miurl..");
//			inmueble1.getImagenes().add(imagen1);
//			
//			session.save(inmueble1);
			
			
			// Eliminar imagen1 del inmueble1
//			Inmueble inmueble1 = session.load(Inmueble.class, 1);
//			Imagen imagen1 = session.load(Imagen.class, 1);
//			
//			inmueble1.getImagenes().remove(imagen1);
//			
//			session.save(inmueble1);
			
			
			// Eliminar todas las imagenes de inmueble 1
//			CriteriaBuilder builder = session.getCriteriaBuilder();
//			CriteriaQuery<Imagen> criteria = builder.createQuery(Imagen.class);
//			Root<Imagen> root = criteria.from(Imagen.class);
//			
//			Join<Imagen, Inmueble> join = root.join(Imagen_.inmuebles);
//			
//			criteria.where(
//						builder.equal(join.get(Inmueble_.idInm), 1)
//					);
//			
//			List<Imagen> results = session.createQuery(criteria).getResultList();
//			Inmueble inmueble1 = session.load(Inmueble.class, 1);
//			
//			for(Imagen imagen : results){
//				inmueble1.getImagenes().remove(imagen);
//				session.save(inmueble1);
//			}
			
			
			// Eliminar todas las imagenes y todos los inmuebles
			Inmueble inmueble1 = session.load(Inmueble.class, 1);
			Imagen imagen1 = session.load(Imagen.class, 1);
			
			inmueble1.getImagenes().remove(imagen1);
			
			session.delete(inmueble1);
			
			
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
