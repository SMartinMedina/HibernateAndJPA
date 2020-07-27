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
import com.novellius.domain.Inmueble;
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
			
			Inmueble inmueble1 = new Inmueble("terreno", "morelos #100");
			Inmueble inmueble2 = new Inmueble("casa", "hidalgo #700");
			
			Imagen imagen1 = new Imagen("www.imageshack...", time);
			Imagen imagen2 = new Imagen("www.drive...", time);
			Imagen imagen3 = new Imagen("www.mega...", time);
			
			inmueble1.getImagenes().add(imagen1);
			inmueble1.getImagenes().add(imagen2);
			
			inmueble2.getImagenes().add(imagen1);
			inmueble2.getImagenes().add(imagen3);
			
			session.save(inmueble1);
			session.save(inmueble2);
			
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
