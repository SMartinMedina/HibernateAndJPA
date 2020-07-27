package com.novellius.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.novellius.domain.Imagen;
import com.novellius.domain.Imagen_;
import com.novellius.domain.Inmueble;
import com.novellius.domain.Inmueble_;

public class InmuebleDaoImpl implements InmuebleDao{
	
	private Session session;
	
	public InmuebleDaoImpl(Session session) {
		this.session = session;
	}

	@Override
	public void save(Inmueble inmueble) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(inmueble);
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	
	@Override
	public List<Imagen> findAll(Inmueble inmueble) {
		Transaction tx = null;
		List<Imagen> results = new ArrayList<>();
		try {
			tx = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Imagen> criteria = builder.createQuery(Imagen.class);
			Root<Imagen> root = criteria.from(Imagen.class);
			
			Join<Imagen, Inmueble> join = root.join(Imagen_.inmuebles);
			
			criteria.where(
					builder.equal(join.get(Inmueble_.idInm), inmueble.getIdInm())
					);
			
			results = session.createQuery(criteria).getResultList();
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
				results = null;
			}
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public Inmueble findById(int id) {
		Transaction tx = null;
		Inmueble inmueble = null;
		try {
			tx = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Inmueble> criteria = builder.createQuery(Inmueble.class);
			Root<Inmueble> root = criteria.from(Inmueble.class);
			
			criteria.where(
					builder.equal(root.get(Inmueble_.idInm), id)
					);
			
			inmueble = session.createQuery(criteria).getSingleResult();
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return inmueble;
	}
	
	
	public void closeSession(){
		session.close();
	}

}
