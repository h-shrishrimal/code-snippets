package com.tcs.rmg.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRequirementRMGDetails is a Querydsl query type for RequirementRMGDetails
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRequirementRMGDetails extends EntityPathBase<RequirementRMGDetails> {

    private static final long serialVersionUID = 1115862056L;

    public static final QRequirementRMGDetails requirementRMGDetails = new QRequirementRMGDetails("requirementRMGDetails");

    public final StringPath geBusiness = createString("geBusiness");

    public final NumberPath<Integer> glEmployeeId = createNumber("glEmployeeId", Integer.class);

    public final StringPath requirementLocation = createString("requirementLocation");

    public final NumberPath<Integer> rmgEmpNo = createNumber("rmgEmpNo", Integer.class);

    public QRequirementRMGDetails(String variable) {
        super(RequirementRMGDetails.class, forVariable(variable));
    }

    public QRequirementRMGDetails(Path<? extends RequirementRMGDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRequirementRMGDetails(PathMetadata metadata) {
        super(RequirementRMGDetails.class, metadata);
    }

}

