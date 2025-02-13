package YUN.sobieNote.Member.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class) // db에 적용하기 전에 콜백
@Table(name = "member_roles")
public class MemberRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 데이터베이스에서 자동으로 넣어줌
    private int id;

    @Column(name = "role", nullable = false, unique = true)
    private String role;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    @LastModifiedDate
    protected LocalDateTime updatedAt;


}
