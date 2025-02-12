package YUN.sobieNote.Board.Entity;

import YUN.sobieNote.Board.Enum.EmotionType;
import YUN.sobieNote.Board.Enum.FactorType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "factors")
public class Factor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 데이터베이스에서 자동으로 넣어줌
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "display_name")
    private String displayName;

}
