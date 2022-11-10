package com.tcs.rmg.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProjectDetails is a Querydsl query type for ProjectDetails
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProjectDetails extends EntityPathBase<ProjectDetails> {

    private static final long serialVersionUID = -1130996902L;

    public static final QProjectDetails projectDetails = new QProjectDetails("projectDetails");

    public final StringPath digitalFlagging = createString("digitalFlagging");

    public final StringPath projectCompletionDate = createString("projectCompletionDate");

    public final StringPath projectName = createString("projectName");

    public final NumberPath<Integer> projectNumber = createNumber("projectNumber", Integer.class);

    public final StringPath projectStartDate = createString("projectStartDate");

    public final StringPath projectStatus = createString("projectStatus");

    public final StringPath projectType = createString("projectType");

    public QProjectDetails(String variable) {
        super(ProjectDetails.class, forVariable(variable));
    }

    public QProjectDetails(Path<? extends ProjectDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProjectDetails(PathMetadata metadata) {
        super(ProjectDetails.class, metadata);
    }

}

