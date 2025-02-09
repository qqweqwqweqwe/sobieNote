package YUN.sobieNote.Board.Entity;

import YUN.sobieNote.Board.Enum.EmotionType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Emotion")
public class Emotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 데이터베이스에서 자동으로 넣어줌
    private int id;

    @Column(name = "type")
    private EmotionType type;


}
