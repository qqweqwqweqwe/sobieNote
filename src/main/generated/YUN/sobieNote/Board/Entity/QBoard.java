package YUN.sobieNote.Board.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = 1974251257L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoard board = new QBoard("board");

    public final QCategory category;

    public final StringPath contents = createString("contents");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> createdAtMonth = createNumber("createdAtMonth", Integer.class);

    public final NumberPath<Integer> createdAtYear = createNumber("createdAtYear", Integer.class);

    public final QEmotion emotion;

    public final QFactor factor;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final YUN.sobieNote.Member.Entity.QMember member;

    public final NumberPath<Long> satisfaction = createNumber("satisfaction", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QBoard(String variable) {
        this(Board.class, forVariable(variable), INITS);
    }

    public QBoard(Path<? extends Board> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoard(PathMetadata metadata, PathInits inits) {
        this(Board.class, metadata, inits);
    }

    public QBoard(Class<? extends Board> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QCategory(forProperty("category")) : null;
        this.emotion = inits.isInitialized("emotion") ? new QEmotion(forProperty("emotion")) : null;
        this.factor = inits.isInitialized("factor") ? new QFactor(forProperty("factor")) : null;
        this.member = inits.isInitialized("member") ? new YUN.sobieNote.Member.Entity.QMember(forProperty("member"), inits.get("member")) : null;
    }

}

