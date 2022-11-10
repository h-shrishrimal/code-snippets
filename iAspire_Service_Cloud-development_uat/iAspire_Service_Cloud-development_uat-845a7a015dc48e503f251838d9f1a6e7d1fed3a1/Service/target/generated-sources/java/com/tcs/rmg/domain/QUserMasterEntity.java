package com.tcs.rmg.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserMasterEntity is a Querydsl query type for UserMasterEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserMasterEntity extends EntityPathBase<UserMasterEntity> {

    private static final long serialVersionUID = -1335864703L;

    public static final QUserMasterEntity userMasterEntity = new QUserMasterEntity("userMasterEntity");

    public final StringPath account = createString("account");

    public final DateTimePath<java.util.Date> allocationEndDate = createDateTime("allocationEndDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> allocationStartDate = createDateTime("allocationStartDate", java.util.Date.class);

    public final StringPath deputeBranch = createString("deputeBranch");

    public final StringPath designation = createString("designation");

    public final StringPath empAMName = createString("empAMName");

    public final NumberPath<Integer> empAMNumber = createNumber("empAMNumber", Integer.class);

    public final StringPath empBRMName = createString("empBRMName");

    public final NumberPath<Integer> empBRMNumber = createNumber("empBRMNumber", Integer.class);

    public final StringPath empGLName = createString("empGLName");

    public final NumberPath<Integer> empGLNumber = createNumber("empGLNumber", Integer.class);

    public final StringPath employeeDeputeCountry = createString("employeeDeputeCountry");

    public final StringPath empName = createString("empName");

    public final StringPath empNo = createString("empNo");

    public final StringPath empPLName = createString("empPLName");

    public final NumberPath<Integer> empPLNumber = createNumber("empPLNumber", Integer.class);

    public final StringPath empRMName = createString("empRMName");

    public final NumberPath<Integer> empRMNumber = createNumber("empRMNumber", Integer.class);

    public final StringPath empSupervisorName = createString("empSupervisorName");

    public final StringPath empSupervisorNumber = createString("empSupervisorNumber");

    public final StringPath grade = createString("grade");

    public final StringPath iou = createString("iou");

    public final StringPath personType = createString("personType");

    public final StringPath projectLocationIndia = createString("projectLocationIndia");

    public final StringPath role = createString("role");

    public final StringPath segment = createString("segment");

    public final StringPath seniorOrJunior = createString("seniorOrJunior");

    public final StringPath teamRole = createString("teamRole");

    public final StringPath tfactorFlag = createString("tfactorFlag");

    public final StringPath totExperience = createString("totExperience");

    public final StringPath wonOrSwon = createString("wonOrSwon");

    public final StringPath workCountry = createString("workCountry");

    public final StringPath workLocation = createString("workLocation");

    public QUserMasterEntity(String variable) {
        super(UserMasterEntity.class, forVariable(variable));
    }

    public QUserMasterEntity(Path<? extends UserMasterEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserMasterEntity(PathMetadata metadata) {
        super(UserMasterEntity.class, metadata);
    }

}

