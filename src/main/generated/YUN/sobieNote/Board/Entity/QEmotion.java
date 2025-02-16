package YUN.sobieNote.Board.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmotion is a Querydsl query type for Emotion
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmotion extends EntityPathBase<Emotion> {

    private static final long serialVersionUID = 1498163118L;

    public static final QEmotion emotion = new QEmotion("emotion");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath displayName = createString("displayName");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QEmotion(String variable) {
        super(Emotion.class, forVariable(variable));
    }

    public QEmotion(Path<? extends Emotion> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmotion(PathMetadata metadata) {
        super(Emotion.class, metadata);
    }

}

