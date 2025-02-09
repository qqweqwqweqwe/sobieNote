package YUN.sobieNote.Board.Entity;

import YUN.sobieNote.Board.Enum.CategoryType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 데이터베이스에서 자동으로 넣어줌
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private CategoryType type;

}
