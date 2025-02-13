package YUN.sobieNote.Board.Entity;

import YUN.sobieNote.Board.Enum.CategoryType;
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
@Table(name = "categories")
@EntityListeners(AuditingEntityListener.class)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 데이터베이스에서 자동으로 넣어줌
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "display_name",nullable = false, unique = true)
    private String displayName;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    @LastModifiedDate
    protected LocalDateTime updatedAt;


}
