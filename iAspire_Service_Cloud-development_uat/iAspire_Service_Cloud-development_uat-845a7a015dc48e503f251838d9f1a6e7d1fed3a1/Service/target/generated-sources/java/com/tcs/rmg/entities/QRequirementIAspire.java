package com.tcs.rmg.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRequirementIAspire is a Querydsl query type for RequirementIAspire
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRequirementIAspire extends EntityPathBase<RequirementIAspire> {

    private static final long serialVersionUID = -980451528L;

    public static final QRequirementIAspire requirementIAspire = new QRequirementIAspire("requirementIAspire");

    public final StringPath agingWrtRqmtStDt = createString("agingWrtRqmtStDt");

    public final StringPath bfsiAccountName = createString("bfsiAccountName");

    public final StringPath bfsiSubSegmentName = createString("bfsiSubSegmentName");

    public final StringPath branch = createString("branch");

    public final StringPath bucketWrtRqmtStDt = createString("bucketWrtRqmtStDt");

    public final StringPath customerName = createString("customerName");

    public final StringPath duType = createString("duType");

    public final StringPath groupCustomerName = createString("groupCustomerName");

    public final StringPath horizontalChildIou = createString("horizontalChildIou");

    public final StringPath horizontalParentIou = createString("horizontalParentIou");

    public final StringPath newSegmentIouName = createString("newSegmentIouName");

    public final StringPath onsiteOffshore = createString("onsiteOffshore");

    public final StringPath parentDu = createString("parentDu");

    public final StringPath primaryCompetencyProficiencyDetails = createString("primaryCompetencyProficiencyDetails");

    public final StringPath projectNumber = createString("projectNumber");

    public final NumberPath<Integer> requestId = createNumber("requestId", Integer.class);

    public final StringPath requirementBgCluster = createString("requirementBgCluster");

    public final StringPath requirementBranch = createString("requirementBranch");

    public final StringPath requirementCity = createString("requirementCity");

    public final StringPath requirementCountry = createString("requirementCountry");

    public final StringPath requirementEndDate = createString("requirementEndDate");

    public final StringPath requirementGeography = createString("requirementGeography");

    public final NumberPath<Integer> requirementId = createNumber("requirementId", Integer.class);

    public final StringPath requirementLocation = createString("requirementLocation");

    public final StringPath requirementParentIou = createString("requirementParentIou");

    public final StringPath requirementPendingWith = createString("requirementPendingWith");

    public final StringPath requirementStartDate = createString("requirementStartDate");

    public final StringPath requirementStatus = createString("requirementStatus");

    public final StringPath requirementType = createString("requirementType");

    public final StringPath requireStatusRequirementStartDate = createString("requireStatusRequirementStartDate");

    public final StringPath rmgOffshoreBranch = createString("rmgOffshoreBranch");

    public final StringPath totalExperience = createString("totalExperience");

    public final StringPath wonSwon = createString("wonSwon");

    public QRequirementIAspire(String variable) {
        super(RequirementIAspire.class, forVariable(variable));
    }

    public QRequirementIAspire(Path<? extends RequirementIAspire> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRequirementIAspire(PathMetadata metadata) {
        super(RequirementIAspire.class, metadata);
    }

}

