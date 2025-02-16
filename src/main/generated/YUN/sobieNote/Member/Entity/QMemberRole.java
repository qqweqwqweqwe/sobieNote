package YUN.sobieNote.Member.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberRole is a Querydsl query type for MemberRole
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberRole extends EntityPathBase<MemberRole> {

    private static final long serialVersionUID = -766861795L;

    public static final QMemberRole memberRole = new QMemberRole("memberRole");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath role = createString("role");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QMemberRole(String variable) {
        super(MemberRole.class, forVariable(variable));
    }

    public QMemberRole(Path<? extends MemberRole> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberRole(PathMetadata metadata) {
        super(MemberRole.class, metadata);
    }

}

