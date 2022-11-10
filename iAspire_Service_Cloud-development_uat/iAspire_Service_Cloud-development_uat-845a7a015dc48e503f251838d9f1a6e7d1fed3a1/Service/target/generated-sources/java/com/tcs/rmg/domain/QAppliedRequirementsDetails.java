package com.tcs.rmg.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAppliedRequirementsDetails is a Querydsl query type for AppliedRequirementsDetails
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAppliedRequirementsDetails extends EntityPathBase<AppliedRequirementsDetails> {

    private static final long serialVersionUID = -523052858L;

    public static final QAppliedRequirementsDetails appliedRequirementsDetails = new QAppliedRequirementsDetails("appliedRequirementsDetails");

    public final StringPath applicantComments = createString("applicantComments");

    public final StringPath applicantContactNumber = createString("applicantContactNumber");

    public final NumberPath<Integer> applicantEmployeeId = createNumber("applicantEmployeeId", Integer.class);

    public final StringPath applicantExperience = createString("applicantExperience");

    public final NumberPath<Integer> applicationId = createNumber("applicationId", Integer.class);

    public final NumberPath<Integer> createdBy = createNumber("createdBy", Integer.class);

    public final StringPath createdDateTimestamp = createString("createdDateTimestamp");

    public final DateTimePath<java.time.LocalDateTime> creationDate = createDateTime("creationDate", java.time.LocalDateTime.class);

    public final StringPath description = createString("description");

    public final StringPath glComments = createString("glComments");

    public final NumberPath<Integer> glEmployeeId = createNumber("glEmployeeId", Integer.class);

    public final StringPath rejReasonRmg = createString("rejReasonRmg");

    public final StringPath rejReasonRq = createString("rejReasonRq");

    public final StringPath releaseDate = createString("releaseDate");

    public final NumberPath<Integer> requestId = createNumber("requestId", Integer.class);

    public final StringPath requestorComments = createString("requestorComments");

    public final NumberPath<Integer> requestorEmployeeId = createNumber("requestorEmployeeId", Integer.class);

    public final StringPath requestorStatus = createString("requestorStatus");

    public final NumberPath<Integer> requirementId = createNumber("requirementId", Integer.class);

    public final StringPath rmgComments = createString("rmgComments");

    public final StringPath rmgEmployeeId = createString("rmgEmployeeId");

    public final StringPath rmgStatus = createString("rmgStatus");

    public final NumberPath<Integer> updatedBy = createNumber("updatedBy", Integer.class);

    public final StringPath updatedDateTimestamp = createString("updatedDateTimestamp");

    public final StringPath validVisa = createString("validVisa");

    public final StringPath visaExpiryDate = createString("visaExpiryDate");

    public final StringPath visaIssueDate = createString("visaIssueDate");

    public final StringPath visaType = createString("visaType");

    public QAppliedRequirementsDetails(String variable) {
        super(AppliedRequirementsDetails.class, forVariable(variable));
    }

    public QAppliedRequirementsDetails(Path<? extends AppliedRequirementsDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAppliedRequirementsDetails(PathMetadata metadata) {
        super(AppliedRequirementsDetails.class, metadata);
    }

}

