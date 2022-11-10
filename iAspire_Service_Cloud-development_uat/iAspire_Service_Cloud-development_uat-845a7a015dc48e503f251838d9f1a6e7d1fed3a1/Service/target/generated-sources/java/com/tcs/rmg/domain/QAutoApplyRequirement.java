package com.tcs.rmg.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAutoApplyRequirement is a Querydsl query type for AutoApplyRequirement
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAutoApplyRequirement extends EntityPathBase<AutoApplyRequirement> {

    private static final long serialVersionUID = 1583994229L;

    public static final QAutoApplyRequirement autoApplyRequirement = new QAutoApplyRequirement("autoApplyRequirement");

    public final NumberPath<Integer> applicantEmployeeId = createNumber("applicantEmployeeId", Integer.class);

    public final NumberPath<Integer> autoapplyRequirementId = createNumber("autoapplyRequirementId", Integer.class);

    public final DateTimePath<java.sql.Timestamp> createdtimestamp = createDateTime("createdtimestamp", java.sql.Timestamp.class);

    public final StringPath cretaeduserid = createString("cretaeduserid");

    public final StringPath isapplied = createString("isapplied");

    public final StringPath reasonForFailure = createString("reasonForFailure");

    public final NumberPath<Integer> requestId = createNumber("requestId", Integer.class);

    public final NumberPath<Integer> requestorEmpId = createNumber("requestorEmpId", Integer.class);

    public final NumberPath<Integer> requirementId = createNumber("requirementId", Integer.class);

    public final DateTimePath<java.sql.Timestamp> updatedtimestamp = createDateTime("updatedtimestamp", java.sql.Timestamp.class);

    public final StringPath updateduserid = createString("updateduserid");

    public QAutoApplyRequirement(String variable) {
        super(AutoApplyRequirement.class, forVariable(variable));
    }

    public QAutoApplyRequirement(Path<? extends AutoApplyRequirement> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAutoApplyRequirement(PathMetadata metadata) {
        super(AutoApplyRequirement.class, metadata);
    }

}

