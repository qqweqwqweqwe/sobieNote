package YUN.sobieNote.Board.Entity;

import YUN.sobieNote.Board.Enum.EmotionType;
import YUN.sobieNote.Board.Enum.FactorType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "factors")
public class Factor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 데이터베이스에서 자동으로 넣어줌
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "display_name", nullable = false, unique = true)
    private String displayName;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    @LastModifiedDate
    protected LocalDateTime updatedAt;


}
