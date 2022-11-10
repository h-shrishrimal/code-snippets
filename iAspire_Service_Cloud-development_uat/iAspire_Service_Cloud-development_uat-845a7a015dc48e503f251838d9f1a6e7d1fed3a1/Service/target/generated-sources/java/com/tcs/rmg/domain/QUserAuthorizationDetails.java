package com.tcs.rmg.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserAuthorizationDetails is a Querydsl query type for UserAuthorizationDetails
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserAuthorizationDetails extends EntityPathBase<UserAuthorizationDetails> {

    private static final long serialVersionUID = -764826331L;

    public static final QUserAuthorizationDetails userAuthorizationDetails = new QUserAuthorizationDetails("userAuthorizationDetails");

    public final StringPath account = createString("account");

    public final NumberPath<Integer> appId = createNumber("appId", Integer.class);

    public final StringPath appName = createString("appName");

    public final StringPath appOwner = createString("appOwner");

    public final DatePath<java.time.LocalDate> createdDate = createDate("createdDate", java.time.LocalDate.class);

    public final StringPath createdUserId = createString("createdUserId");

    public final StringPath empName = createString("empName");

    public final StringPath empNumber = createString("empNumber");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath isuName = createString("isuName");

    public final NumberPath<Integer> level = createNumber("level", Integer.class);

    public final StringPath roleName = createString("roleName");

    public final StringPath segment = createString("segment");

    public final StringPath superUser = createString("superUser");

    public final DatePath<java.time.LocalDate> updatedDate = createDate("updatedDate", java.time.LocalDate.class);

    public final StringPath updatedUserId = createString("updatedUserId");

    public QUserAuthorizationDetails(String variable) {
        super(UserAuthorizationDetails.class, forVariable(variable));
    }

    public QUserAuthorizationDetails(Path<? extends UserAuthorizationDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserAuthorizationDetails(PathMetadata metadata) {
        super(UserAuthorizationDetails.class, metadata);
    }

}

