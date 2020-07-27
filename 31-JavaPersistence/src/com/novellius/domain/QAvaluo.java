package com.novellius.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAvaluo is a Querydsl query type for Avaluo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAvaluo extends EntityPathBase<Avaluo> {

    private static final long serialVersionUID = -1586247616L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAvaluo avaluo = new QAvaluo("avaluo");

    public final NumberPath<Integer> idAval = createNumber("idAval", Integer.class);

    public final StringPath lugarAval = createString("lugarAval");

    public final QTramite tramite;

    public QAvaluo(String variable) {
        this(Avaluo.class, forVariable(variable), INITS);
    }

    public QAvaluo(Path<? extends Avaluo> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAvaluo(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAvaluo(PathMetadata<?> metadata, PathInits inits) {
        this(Avaluo.class, metadata, inits);
    }

    public QAvaluo(Class<? extends Avaluo> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tramite = inits.isInitialized("tramite") ? new QTramite(forProperty("tramite"), inits.get("tramite")) : null;
    }

}

