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
import com.novellius.domain.Tramite;
import com.novellius.domain.Tramite_;
import com.novellius.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
//			Tramite tramite = new Tramite("Proyecto ejecutivo", new Timestamp(new Date().getTime()));
//			session.save(tramite);
//			Avaluo avaluo = new Avaluo("hidalgo #102");
//			avaluo.setTramite(tramite);
//			session.save(avaluo);
			
			Tramite tramite2 = session.load(Tramite.class, 2);
			Avaluo avaluo2 = new Avaluo("calzada veracruz #1000");
			avaluo2.setTramite(tramite2);
			session.save(avaluo2);
			
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
