package com.tcs.rmg.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserRequirementMapping is a Querydsl query type for UserRequirementMapping
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserRequirementMapping extends EntityPathBase<UserRequirementMapping> {

    private static final long serialVersionUID = 297375655L;

    public static final QUserRequirementMapping userRequirementMapping = new QUserRequirementMapping("userRequirementMapping");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> requirementId = createNumber("requirementId", Integer.class);

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public QUserRequirementMapping(String variable) {
        super(UserRequirementMapping.class, forVariable(variable));
    }

    public QUserRequirementMapping(Path<? extends UserRequirementMapping> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserRequirementMapping(PathMetadata metadata) {
        super(UserRequirementMapping.class, metadata);
    }

}

