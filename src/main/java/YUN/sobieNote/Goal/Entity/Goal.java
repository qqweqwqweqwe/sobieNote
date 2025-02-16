package YUN.sobieNote.Goal.Entity;

import YUN.sobieNote.Member.Entity.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 데이터베이스에서 자동으로 넣어줌
    private int id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "contents", nullable = false)
    private String contents;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "month", nullable = false)
    private int month;

    // 가상 컬럼 생성
    @Formula("YEAR(created_at)") // DB의 YEAR(created_at) 값 저장
    private int createdAtYear;

    // 가상 컬럼 생성
    @Formula("MONTH(created_at)") // DB의 MONTH(created_at) 값 저장
    private int createdAtMonth;


    @Column(name = "created_at", updatable = false) // 열 이름을 지정하고 수정 불가능
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public void updateContents(String mission){
        this.contents = mission;
    }
}
