package com.tcs.rmg.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserMasterData is a Querydsl query type for UserMasterData
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserMasterData extends EntityPathBase<UserMasterData> {

    private static final long serialVersionUID = 218839010L;

    public static final QUserMasterData userMasterData = new QUserMasterData("userMasterData");

    public final StringPath account = createString("account");

    public final DateTimePath<java.util.Date> allocationEndDate = createDateTime("allocationEndDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> allocationStartDate = createDateTime("allocationStartDate", java.util.Date.class);

    public final StringPath customer = createString("customer");

    public final StringPath designation = createString("designation");

    public final StringPath empName = createString("empName");

    public final StringPath empNumber = createString("empNumber");

    public final StringPath empSupervisorName = createString("empSupervisorName");

    public final StringPath empSupervisorNumber = createString("empSupervisorNumber");

    public final StringPath grade = createString("grade");

    public final StringPath iou = createString("iou");

    public final StringPath projectLocationIndia = createString("projectLocationIndia");

    public final StringPath role = createString("role");

    public final StringPath segment = createString("segment");

    public final StringPath seniorOrJunior = createString("seniorOrJunior");

    public final StringPath teamRole = createString("teamRole");

    public final StringPath wonOrSwon = createString("wonOrSwon");

    public final StringPath workCountry = createString("workCountry");

    public final StringPath workLocation = createString("workLocation");

    public QUserMasterData(String variable) {
        super(UserMasterData.class, forVariable(variable));
    }

    public QUserMasterData(Path<? extends UserMasterData> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserMasterData(PathMetadata metadata) {
        super(UserMasterData.class, metadata);
    }

}

