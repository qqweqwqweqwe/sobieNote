package YUN.sobieNote.Board.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardRequest {

    private String contents;
    private String emotions;
    private long satisfactions;
    private String factors;
    private String categories;

    public BoardRequest(String contents, String emotions, long satisfactions, String factors, String categories) {
        this.contents = contents;
        this.emotions = emotions;
        this.satisfactions = satisfactions;
        this.factors = factors;
        this.categories = categories;
    }
}
