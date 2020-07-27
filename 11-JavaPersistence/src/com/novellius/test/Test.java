package com.novellius.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.novellius.domain.Tramite;
import com.novellius.domain.Tramite_;
import com.novellius.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			// Fábrica para las piezas individuales de la criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Tuple> criteria = builder.createQuery(Tuple.class);

			Root<Tramite> root = criteria.from(Tramite.class);
			
			Path<Integer> idTramPath = root.get(Tramite_.idTram);
			Path<Timestamp> fhcTramPath = root.get(Tramite_.fhcTram);

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date parsedDate = dateFormat.parse("2016-08-08 15:05:58");
			
			// Construyendo la consulta
			criteria.multiselect(idTramPath, fhcTramPath)
					.where(builder.and(
								builder.like(root.get(Tramite_.tipoTram), "%crédito%"),
								builder.lessThan(root.<Timestamp>get(Tramite_.fhcTram), new Timestamp(parsedDate.getTime()))
								)
						   );

			List<Tuple> tuples = session.createQuery(criteria).getResultList();
			for(Tuple tuple : tuples){
				System.out.println("tupla: " +  tuple.get(idTramPath) + ", " + tuple.get(fhcTramPath));
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
