package com.tcs.rmg.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRequestorRecommendationDetails is a Querydsl query type for RequestorRecommendationDetails
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRequestorRecommendationDetails extends EntityPathBase<RequestorRecommendationDetails> {

    private static final long serialVersionUID = -563188952L;

    public static final QRequestorRecommendationDetails requestorRecommendationDetails = new QRequestorRecommendationDetails("requestorRecommendationDetails");

    public final StringPath applicantExperience = createString("applicantExperience");

    public final StringPath empCompetency = createString("empCompetency");

    public final StringPath employeeExperience = createString("employeeExperience");

    public final NumberPath<Integer> employeeId = createNumber("employeeId", Integer.class);

    public final StringPath employeeName = createString("employeeName");

    public final StringPath ievolveMatch = createString("ievolveMatch");

    public final StringPath overallTFactor = createString("overallTFactor");

    public final StringPath reqCometency = createString("reqCometency");

    public final NumberPath<Integer> requestId = createNumber("requestId", Integer.class);

    public final NumberPath<Integer> requestorEmployeeId = createNumber("requestorEmployeeId", Integer.class);

    public final StringPath requestorEmployeeName = createString("requestorEmployeeName");

    public final NumberPath<Integer> requirementId = createNumber("requirementId", Integer.class);

    public QRequestorRecommendationDetails(String variable) {
        super(RequestorRecommendationDetails.class, forVariable(variable));
    }

    public QRequestorRecommendationDetails(Path<? extends RequestorRecommendationDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRequestorRecommendationDetails(PathMetadata metadata) {
        super(RequestorRecommendationDetails.class, metadata);
    }

}

