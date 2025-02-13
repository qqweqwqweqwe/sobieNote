package YUN.sobieNote.Board.Entity;

import YUN.sobieNote.Board.DTO.BoardPostRequest;
import YUN.sobieNote.Goal.Entity.Goal;
import YUN.sobieNote.Member.Entity.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class) // db에 적용하기 전에 콜백
@Table(name = "boards")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 데이터베이스에서 자동으로 넣어줌
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "emotion_id")
    private Emotion emotion;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "factor_id")
    private Factor factor;

    @Column(name = "image_path", nullable = true)
    private String imageUrl;

    @Column(name = "satisfaction")
    private long satisfaction;

    @Column(name = "contents")
    private String contents;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    // 가상 컬럼 생성
    @Formula("YEAR(created_at)") // DB의 YEAR(created_at) 값 저장
    private int createdAtYear;

    // 가상 컬럼 생성
    @Formula("MONTH(created_at)") // DB의 MONTH(created_at) 값 저장
    private int createdAtMonth;


    @Column(name = "updated_at", insertable = false)
    @LastModifiedDate
    protected LocalDateTime updatedAt;

    public Board(BoardPostRequest boardPostRequest, Emotion emotion, Category category, Factor factor,Member member) {
        this.member = member;
        this.emotion = emotion;
        this.category = category;
        this.factor = factor;
        this.satisfaction = boardPostRequest.getSatisfactions();
        this.contents = boardPostRequest.getContents();
        this.imageUrl = "test";
    }
}
