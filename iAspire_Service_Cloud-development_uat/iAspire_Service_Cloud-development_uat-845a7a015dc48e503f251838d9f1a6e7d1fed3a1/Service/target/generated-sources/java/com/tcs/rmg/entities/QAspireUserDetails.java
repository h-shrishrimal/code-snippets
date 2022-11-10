package com.tcs.rmg.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAspireUserDetails is a Querydsl query type for AspireUserDetails
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAspireUserDetails extends EntityPathBase<AspireUserDetails> {

    private static final long serialVersionUID = -1823973531L;

    public static final QAspireUserDetails aspireUserDetails = new QAspireUserDetails("aspireUserDetails");

    public final StringPath assignmentStatus = createString("assignmentStatus");

    public final StringPath bg = createString("bg");

    public final StringPath completionCertificationId = createString("completionCertificationId");

    public final StringPath completionCertificationName = createString("completionCertificationName");

    public final StringPath completionDate = createString("completionDate");

    public final StringPath deliveryUnit = createString("deliveryUnit");

    public final StringPath department = createString("department");

    public final StringPath employeeDeputeBranch = createString("employeeDeputeBranch");

    public final StringPath employeeGrade = createString("employeeGrade");

    public final NumberPath<Integer> employeeNumber = createNumber("employeeNumber", Integer.class);

    public final StringPath employeeParentIou = createString("employeeParentIou");

    public final StringPath empRole = createString("empRole");

    public final StringPath geography = createString("geography");

    public final StringPath groupCustomer = createString("groupCustomer");

    public final StringPath localExpat = createString("localExpat");

    public final StringPath mappedParentOuExcludingBps = createString("mappedParentOuExcludingBps");

    public final StringPath mappedProjectOu = createString("mappedProjectOu");

    public final StringPath mappedSubIouParentOuExcludingBps = createString("mappedSubIouParentOuExcludingBps");

    public final StringPath mappedSubProjectOu = createString("mappedSubProjectOu");

    public final StringPath mltPoolCategory = createString("mltPoolCategory");

    public final StringPath projectIou = createString("projectIou");

    public final StringPath projectType = createString("projectType");

    public final StringPath region = createString("region");

    public final StringPath status = createString("status");

    public final StringPath tcsExp = createString("tcsExp");

    public final StringPath totalRelExp = createString("totalRelExp");

    public final StringPath unlockOtherIsu = createString("unlockOtherIsu");

    public final StringPath wonSwon = createString("wonSwon");

    public QAspireUserDetails(String variable) {
        super(AspireUserDetails.class, forVariable(variable));
    }

    public QAspireUserDetails(Path<? extends AspireUserDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAspireUserDetails(PathMetadata metadata) {
        super(AspireUserDetails.class, metadata);
    }

}

