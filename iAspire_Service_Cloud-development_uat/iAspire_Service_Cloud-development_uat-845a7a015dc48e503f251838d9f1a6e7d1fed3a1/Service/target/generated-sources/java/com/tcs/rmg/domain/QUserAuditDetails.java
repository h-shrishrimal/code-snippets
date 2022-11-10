package com.tcs.rmg.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserAuditDetails is a Querydsl query type for UserAuditDetails
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserAuditDetails extends EntityPathBase<UserAuditDetails> {

    private static final long serialVersionUID = 308681603L;

    public static final QUserAuditDetails userAuditDetails = new QUserAuditDetails("userAuditDetails");

    public final NumberPath<Integer> auditId = createNumber("auditId", Integer.class);

    public final DateTimePath<java.util.Date> auditTimestamp = createDateTime("auditTimestamp", java.util.Date.class);

    public final StringPath userAction = createString("userAction");

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public QUserAuditDetails(String variable) {
        super(UserAuditDetails.class, forVariable(variable));
    }

    public QUserAuditDetails(Path<? extends UserAuditDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserAuditDetails(PathMetadata metadata) {
        super(UserAuditDetails.class, metadata);
    }

}

