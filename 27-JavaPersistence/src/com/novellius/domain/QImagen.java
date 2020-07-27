package com.novellius.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QImagen is a Querydsl query type for Imagen
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QImagen extends EntityPathBase<Imagen> {

    private static final long serialVersionUID = -1365531399L;

    public static final QImagen imagen = new QImagen("imagen");

    public final DateTimePath<java.sql.Timestamp> fhcImg = createDateTime("fhcImg", java.sql.Timestamp.class);

    public final NumberPath<Integer> idImg = createNumber("idImg", Integer.class);

    public final ListPath<Inmueble, QInmueble> inmuebles = this.<Inmueble, QInmueble>createList("inmuebles", Inmueble.class, QInmueble.class, PathInits.DIRECT2);

    public final StringPath urlImg = createString("urlImg");

    public QImagen(String variable) {
        super(Imagen.class, forVariable(variable));
    }

    public QImagen(Path<? extends Imagen> path) {
        super(path.getType(), path.getMetadata());
    }

    public QImagen(PathMetadata<?> metadata) {
        super(Imagen.class, metadata);
    }

}

