package YUN.sobieNote.Goal.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGoal is a Querydsl query type for Goal
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGoal extends EntityPathBase<Goal> {

    private static final long serialVersionUID = 184497465L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGoal goal = new QGoal("goal");

    public final StringPath contents = createString("contents");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> createdAtMonth = createNumber("createdAtMonth", Integer.class);

    public final NumberPath<Integer> createdAtYear = createNumber("createdAtYear", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final YUN.sobieNote.Member.Entity.QMember member;

    public final NumberPath<Integer> month = createNumber("month", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QGoal(String variable) {
        this(Goal.class, forVariable(variable), INITS);
    }

    public QGoal(Path<? extends Goal> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGoal(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGoal(PathMetadata metadata, PathInits inits) {
        this(Goal.class, metadata, inits);
    }

    public QGoal(Class<? extends Goal> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new YUN.sobieNote.Member.Entity.QMember(forProperty("member"), inits.get("member")) : null;
    }

}

