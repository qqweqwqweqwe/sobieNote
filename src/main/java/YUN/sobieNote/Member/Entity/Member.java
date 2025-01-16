package YUN.sobieNote.Member.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 데이터베이스에서 자동으로 넣어줌
    private long id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = false) // 고유(unique) 및 Not Null 설정
    private String email;

    @Column(name = "created_at", updatable = false) // 열 이름을 지정하고 수정 불가능
    @CreationTimestamp
    private final LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt = LocalDateTime.now();


}
