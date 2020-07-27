package com.novellius.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QDiarioCliente is a Querydsl query type for DiarioCliente
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDiarioCliente extends EntityPathBase<DiarioCliente> {

    private static final long serialVersionUID = 252816888L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDiarioCliente diarioCliente = new QDiarioCliente("diarioCliente");

    public final StringPath entradaDiario = createString("entradaDiario");

    public final DateTimePath<java.sql.Timestamp> fhcDiario = createDateTime("fhcDiario", java.sql.Timestamp.class);

    public final NumberPath<Integer> idDiario = createNumber("idDiario", Integer.class);

    public final QTramite tramite;

    public QDiarioCliente(String variable) {
        this(DiarioCliente.class, forVariable(variable), INITS);
    }

    public QDiarioCliente(Path<? extends DiarioCliente> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDiarioCliente(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDiarioCliente(PathMetadata<?> metadata, PathInits inits) {
        this(DiarioCliente.class, metadata, inits);
    }

    public QDiarioCliente(Class<? extends DiarioCliente> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tramite = inits.isInitialized("tramite") ? new QTramite(forProperty("tramite"), inits.get("tramite")) : null;
    }

}

