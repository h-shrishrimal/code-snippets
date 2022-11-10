package com.tcs.rmg.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDropDownEntity is a Querydsl query type for DropDownEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDropDownEntity extends EntityPathBase<DropDownEntity> {

    private static final long serialVersionUID = -942867995L;

    public static final QDropDownEntity dropDownEntity = new QDropDownEntity("dropDownEntity");

    public final StringPath dropdownColumn = createString("dropdownColumn");

    public final StringPath dropdownValue = createString("dropdownValue");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public QDropDownEntity(String variable) {
        super(DropDownEntity.class, forVariable(variable));
    }

    public QDropDownEntity(Path<? extends DropDownEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDropDownEntity(PathMetadata metadata) {
        super(DropDownEntity.class, metadata);
    }

}

