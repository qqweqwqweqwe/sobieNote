package YUN.sobieNote.Board.DTO;

import YUN.sobieNote.Board.Entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardGetResponse {

    private String result;
    private String msg;
    private Data data;

    public BoardGetResponse(Board board, String result, String msg) {
        this.data = new Data(board);
        this.result = result;
        this.msg = msg;

    }


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data {
        private LocalDateTime createdDate;
        private String emotions;
        private long satisfactions;
        private String categories;
        private String factors;  // ?
        private String contents;

        public Data(Board board) {
            this.emotions = board.getEmotion().getDisplayName();
            this.categories = board.getCategory().getDisplayName();
            this.contents = board.getContents();
            this.factors = board.getFactor().getDisplayName();
            this.satisfactions = board.getSatisfaction();
            this.createdDate = board.getCreatedAt();


        }
    }

}
