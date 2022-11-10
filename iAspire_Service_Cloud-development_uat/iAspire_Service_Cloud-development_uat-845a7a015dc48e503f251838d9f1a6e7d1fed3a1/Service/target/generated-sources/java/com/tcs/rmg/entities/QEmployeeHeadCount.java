package com.tcs.rmg.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmployeeHeadCount is a Querydsl query type for EmployeeHeadCount
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmployeeHeadCount extends EntityPathBase<EmployeeHeadCount> {

    private static final long serialVersionUID = -633281683L;

    public static final QEmployeeHeadCount employeeHeadCount = new QEmployeeHeadCount("employeeHeadCount");

    public final StringPath account = createString("account");

    public final StringPath age = createString("age");

    public final StringPath allocationEndDate = createString("allocationEndDate");

    public final StringPath allocationStartDate = createString("allocationStartDate");

    public final StringPath aniPool = createString("aniPool");

    public final StringPath assignmentStatus = createString("assignmentStatus");

    public final StringPath baCompanyName = createString("baCompanyName");

    public final StringPath ccNonCc = createString("ccNonCc");

    public final StringPath clientCountry = createString("clientCountry");

    public final StringPath clientGeography = createString("clientGeography");

    public final StringPath customer = createString("customer");

    public final StringPath dateOfJoining = createString("dateOfJoining");

    public final StringPath deputeGeo = createString("deputeGeo");

    public final StringPath emailId = createString("emailId");

    public final StringPath empCurrentRole = createString("empCurrentRole");

    public final StringPath employeeBaseBranch = createString("employeeBaseBranch");

    public final StringPath employeeBaseCountry = createString("employeeBaseCountry");

    public final StringPath employeeBaseDc = createString("employeeBaseDc");

    public final StringPath employeeChildIou = createString("employeeChildIou");

    public final StringPath employeeCluster = createString("employeeCluster");

    public final StringPath employeeDepartmentName = createString("employeeDepartmentName");

    public final StringPath employeeDeputeBranch = createString("employeeDeputeBranch");

    public final StringPath employeeDeputeCountry = createString("employeeDeputeCountry");

    public final StringPath employeeDeputeSob = createString("employeeDeputeSob");

    public final StringPath employeeDesignationName = createString("employeeDesignationName");

    public final StringPath employeeGrade = createString("employeeGrade");

    public final NumberPath<Integer> employeeId = createNumber("employeeId", Integer.class);

    public final StringPath employeeLocation = createString("employeeLocation");

    public final StringPath employeeName = createString("employeeName");

    public final StringPath employeeOrganization = createString("employeeOrganization");

    public final StringPath employeeParentIou = createString("employeeParentIou");

    public final StringPath expatLocal = createString("expatLocal");

    public final StringPath gender = createString("gender");

    public final StringPath glEmpId = createString("glEmpId");

    public final StringPath glName = createString("glName");

    public final StringPath groupCustomer = createString("groupCustomer");

    public final StringPath hcCategory = createString("hcCategory");

    public final StringPath highPerformerTwoYearsBand = createString("highPerformerTwoYearsBand");

    public final StringPath itBps = createString("itBps");

    public final StringPath juniorMiddleSenior = createString("juniorMiddleSenior");

    public final StringPath mappedGrade = createString("mappedGrade");

    public final StringPath mappedIsuParent = createString("mappedIsuParent");

    public final StringPath mappedIsuProject = createString("mappedIsuProject");

    public final StringPath mappedSubIsuParent = createString("mappedSubIsuParent");

    public final StringPath mappedSubIsuProject = createString("mappedSubIsuProject");

    public final StringPath mltPool = createString("mltPool");

    public final StringPath nationality = createString("nationality");

    public final StringPath onsiteOffshore = createString("onsiteOffshore");

    public final StringPath parentHorizontal = createString("parentHorizontal");

    public final StringPath personType = createString("personType");

    public final StringPath plEmpId = createString("plEmpId");

    public final StringPath plName = createString("plName");

    public final StringPath prevRelExpinYrs = createString("prevRelExpinYrs");

    public final StringPath projectDescription = createString("projectDescription");

    public final StringPath projectDu = createString("projectDu");

    public final StringPath projectIou = createString("projectIou");

    public final StringPath projectIp = createString("projectIp");

    public final StringPath projectName = createString("projectName");

    public final StringPath projectNumber = createString("projectNumber");

    public final StringPath projectOwnerEmpId = createString("projectOwnerEmpId");

    public final StringPath projectOwnerMisc = createString("projectOwnerMisc");

    public final StringPath projectOwnerName = createString("projectOwnerName");

    public final StringPath projectSp = createString("projectSp");

    public final StringPath projectSubDu = createString("projectSubDu");

    public final StringPath projectSubIou = createString("projectSubIou");

    public final StringPath projectSubIp = createString("projectSubIp");

    public final StringPath projectType = createString("projectType");

    public final StringPath sameCustomerThreeYrsAndAbove = createString("sameCustomerThreeYrsAndAbove");

    public final StringPath sameGroupCustomerDurationYear = createString("sameGroupCustomerDurationYear");

    public final StringPath spanOfControlTotal = createString("spanOfControlTotal");

    public final StringPath subSp = createString("subSp");

    public final StringPath tcsExpinYrs = createString("tcsExpinYrs");

    public final StringPath totalRelExpinYrs = createString("totalRelExpinYrs");

    public final StringPath travelCountry = createString("travelCountry");

    public final StringPath travelType = createString("travelType");

    public final StringPath uniqueGroupCustomer = createString("uniqueGroupCustomer");

    public final StringPath wonSwon = createString("wonSwon");

    public final StringPath workCountry = createString("workCountry");

    public final StringPath workLocation = createString("workLocation");

    public final StringPath workState = createString("workState");

    public QEmployeeHeadCount(String variable) {
        super(EmployeeHeadCount.class, forVariable(variable));
    }

    public QEmployeeHeadCount(Path<? extends EmployeeHeadCount> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmployeeHeadCount(PathMetadata metadata) {
        super(EmployeeHeadCount.class, metadata);
    }

}

