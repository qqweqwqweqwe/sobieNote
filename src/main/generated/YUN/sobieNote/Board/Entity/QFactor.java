package YUN.sobieNote.Board.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFactor is a Querydsl query type for Factor
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFactor extends EntityPathBase<Factor> {

    private static final long serialVersionUID = 1173896092L;

    public static final QFactor factor = new QFactor("factor");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath displayName = createString("displayName");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QFactor(String variable) {
        super(Factor.class, forVariable(variable));
    }

    public QFactor(Path<? extends Factor> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFactor(PathMetadata metadata) {
        super(Factor.class, metadata);
    }

}

