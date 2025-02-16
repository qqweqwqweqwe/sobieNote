package YUN.sobieNote.Member.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuthProvider is a Querydsl query type for AuthProvider
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAuthProvider extends EntityPathBase<AuthProvider> {

    private static final long serialVersionUID = 806671462L;

    public static final QAuthProvider authProvider1 = new QAuthProvider("authProvider1");

    public final StringPath authProvider = createString("authProvider");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QAuthProvider(String variable) {
        super(AuthProvider.class, forVariable(variable));
    }

    public QAuthProvider(Path<? extends AuthProvider> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuthProvider(PathMetadata metadata) {
        super(AuthProvider.class, metadata);
    }

}

