package YUN.sobieNote.Member.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false) // 고유(unique) 및 Not Null 설정
    private String email;

    @Column(name = "created_at", updatable = false) // 열 이름을 지정하고 수정 불가능
    private LocalDateTime createdAt = LocalDateTime.now();

}
