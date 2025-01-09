package YUN.sobieNote.Board.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest {

    private String contents;
    private String emotions;
    private long satisfactions;
    private String factors;
    private String categories;

}
