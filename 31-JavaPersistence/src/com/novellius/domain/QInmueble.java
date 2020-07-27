package com.novellius.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QInmueble is a Querydsl query type for Inmueble
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QInmueble extends EntityPathBase<Inmueble> {

    private static final long serialVersionUID = -1066674455L;

    public static final QInmueble inmueble = new QInmueble("inmueble");

    public final StringPath domInm = createString("domInm");

    public final NumberPath<Integer> idInm = createNumber("idInm", Integer.class);

    public final ListPath<Imagen, QImagen> imagenes = this.<Imagen, QImagen>createList("imagenes", Imagen.class, QImagen.class, PathInits.DIRECT2);

    public final StringPath tipoInm = createString("tipoInm");

    public QInmueble(String variable) {
        super(Inmueble.class, forVariable(variable));
    }

    public QInmueble(Path<? extends Inmueble> path) {
        super(path.getType(), path.getMetadata());
    }

    public QInmueble(PathMetadata<?> metadata) {
        super(Inmueble.class, metadata);
    }

}

