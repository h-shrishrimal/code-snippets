package com.tcs.rmg.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmployeeTFactorDetails is a Querydsl query type for EmployeeTFactorDetails
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmployeeTFactorDetails extends EntityPathBase<EmployeeTFactorDetails> {

    private static final long serialVersionUID = -1420994146L;

    public static final QEmployeeTFactorDetails employeeTFactorDetails = new QEmployeeTFactorDetails("employeeTFactorDetails");

    public final StringPath employeeName = createString("employeeName");

    public final NumberPath<Integer> employeeNumber = createNumber("employeeNumber", Integer.class);

    public final StringPath tFactor = createString("tFactor");

    public QEmployeeTFactorDetails(String variable) {
        super(EmployeeTFactorDetails.class, forVariable(variable));
    }

    public QEmployeeTFactorDetails(Path<? extends EmployeeTFactorDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmployeeTFactorDetails(PathMetadata metadata) {
        super(EmployeeTFactorDetails.class, metadata);
    }

}

