package com.novellius.domain;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Imagen.class)
public abstract class Imagen_ {

	public static volatile SingularAttribute<Imagen, Timestamp> fhcImg;
	public static volatile SingularAttribute<Imagen, String> urlImg;
	public static volatile SingularAttribute<Imagen, Integer> idImg;
	public static volatile ListAttribute<Imagen, Inmueble> inmuebles;

}

