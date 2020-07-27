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
			
			// Crear un avalúo para el tramite existente
//			Tramite tramite = session.load(Tramite.class, 2);
//			Avaluo avaluo = new Avaluo("morelos #100");
//			avaluo.setTramite(tramite);
//			session.save(avaluo);
			
			// Actualizar avalúo
//			Avaluo avaluo2 = session.load(Avaluo.class, 3);
//			avaluo2.setLugarAval("otra dirección");
//			session.update(avaluo2);
			
			// Eliminar sólo el avalúo
//			session.delete(avaluo2);
			
			// Elimiar trámite y su avalúo
			Tramite tramite2 = session.load(Tramite.class, 2);
			session.delete(tramite2);
			
			
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
