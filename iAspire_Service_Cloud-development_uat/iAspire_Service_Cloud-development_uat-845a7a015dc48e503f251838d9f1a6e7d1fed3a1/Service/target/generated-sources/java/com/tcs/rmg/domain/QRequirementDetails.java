package com.tcs.rmg.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRequirementDetails is a Querydsl query type for RequirementDetails
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRequirementDetails extends EntityPathBase<RequirementDetails> {

    private static final long serialVersionUID = 175466096L;

    public static final QRequirementDetails requirementDetails = new QRequirementDetails("requirementDetails");

    public final StringPath business = createString("business");

    public final StringPath competencyProficiencyDetails = createString("competencyProficiencyDetails");

    public final StringPath exciting_opp = createString("exciting_opp");

    public final StringPath isu = createString("isu");

    public final StringPath onsiteOffshore = createString("onsiteOffshore");

    public final StringPath prerequisite_exp = createString("prerequisite_exp");

    public final StringPath requestCreatedOn = createString("requestCreatedOn");

    public final NumberPath<Integer> requestId = createNumber("requestId", Integer.class);

    public final NumberPath<Integer> requestorEmpId = createNumber("requestorEmpId", Integer.class);

    public final StringPath requirementBranch = createString("requirementBranch");

    public final StringPath requirementCity = createString("requirementCity");

    public final StringPath requirementCountry = createString("requirementCountry");

    public final StringPath requirementGeography = createString("requirementGeography");

    public final NumberPath<Integer> requirementId = createNumber("requirementId", Integer.class);

    public final StringPath requirementStatus = createString("requirementStatus");

    public final StringPath role = createString("role");

    public final StringPath role_description = createString("role_description");

    public final StringPath skill = createString("skill");

    public final StringPath totalExperience = createString("totalExperience");

    public final StringPath userNotified = createString("userNotified");

    public QRequirementDetails(String variable) {
        super(RequirementDetails.class, forVariable(variable));
    }

    public QRequirementDetails(Path<? extends RequirementDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRequirementDetails(PathMetadata metadata) {
        super(RequirementDetails.class, metadata);
    }

}

