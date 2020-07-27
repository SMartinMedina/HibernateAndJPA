package com.novellius.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QTramite is a Querydsl query type for Tramite
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTramite extends EntityPathBase<Tramite> {

    private static final long serialVersionUID = 1934134122L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTramite tramite = new QTramite("tramite");

    public final QAvaluo avaluo;

    public final SetPath<DiarioCliente, QDiarioCliente> diarioClienteSet = this.<DiarioCliente, QDiarioCliente>createSet("diarioClienteSet", DiarioCliente.class, QDiarioCliente.class, PathInits.DIRECT2);

    public final DateTimePath<java.sql.Timestamp> fhcTram = createDateTime("fhcTram", java.sql.Timestamp.class);

    public final NumberPath<Integer> idTram = createNumber("idTram", Integer.class);

    public final StringPath tipoTram = createString("tipoTram");

    public QTramite(String variable) {
        this(Tramite.class, forVariable(variable), INITS);
    }

    public QTramite(Path<? extends Tramite> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTramite(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTramite(PathMetadata<?> metadata, PathInits inits) {
        this(Tramite.class, metadata, inits);
    }

    public QTramite(Class<? extends Tramite> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.avaluo = inits.isInitialized("avaluo") ? new QAvaluo(forProperty("avaluo"), inits.get("avaluo")) : null;
    }

}

