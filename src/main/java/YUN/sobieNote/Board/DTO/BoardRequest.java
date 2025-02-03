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

    public BoardRequest(BoardRequest boardRequest) {
        this.contents = boardRequest.contents;
        this.emotions = boardRequest.emotions;
        this.satisfactions = boardRequest.satisfactions;
        this.factors = boardRequest.factors;
        this.categories = boardRequest.categories;
    }
}
