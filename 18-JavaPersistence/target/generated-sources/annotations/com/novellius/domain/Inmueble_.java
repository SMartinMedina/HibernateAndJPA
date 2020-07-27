package com.novellius.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Inmueble.class)
public abstract class Inmueble_ {

	public static volatile ListAttribute<Inmueble, Imagen> imagenes;
	public static volatile SingularAttribute<Inmueble, String> domInm;
	public static volatile SingularAttribute<Inmueble, String> tipoInm;
	public static volatile SingularAttribute<Inmueble, Integer> idInm;

}

