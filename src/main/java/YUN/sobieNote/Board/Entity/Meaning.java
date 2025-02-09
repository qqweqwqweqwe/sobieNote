package YUN.sobieNote.Board.Entity;

import YUN.sobieNote.Board.Enum.MeaningType;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "meaning")

public class Meaning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 데이터베이스에서 자동으로 넣어줌
    private int id;

    @Column(name = "type")
    private MeaningType type;

}
