package YUN.sobieNote.Member.Entity;

import YUN.sobieNote.Board.Entity.Board;
import YUN.sobieNote.Member.DTO.MemberLoginRequest;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 데이터베이스에서 자동으로 넣어줌
    private int id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = false) // 고유(unique) 및 Not Null 설정
    private String email;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "role_id")
    private MemberRole memberRole;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "auth_provider_id")
    private AuthProvider authProvider;

    @Column(name = "created_at", updatable = false) // 열 이름을 지정하고 수정 불가능
    @CreationTimestamp
    private final LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boards;


    public Member(MemberLoginRequest memberLoginRequest, AuthProvider authProvider,MemberRole memberRole) {
        this.name = memberLoginRequest.getName();
        this.email = memberLoginRequest.getEmail();
        this.authProvider = authProvider;
        this.memberRole = memberRole;

    }
}
