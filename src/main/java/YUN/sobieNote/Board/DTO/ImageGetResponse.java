package YUN.sobieNote.Board.DTO;

import YUN.sobieNote.Board.Entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ImageGetResponse {
    private String result;
    private String msg;
    private Data data;

    public ImageGetResponse(Board board, String result, String msg) {
        this.data = new Data(board);
        this.result = result;
        this.msg = msg;
    }


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data {
        private String contents;
        private LocalDateTime createdDate;
        private String categories;
        private String emotions;
        private long satisfactions;
        private String factors;

        public Data(Board board) {
            this.emotions = board.getEmotion().getType().name();
            this.categories = board.getCategory().getType().name();
            this.contents = board.getContents();
            this.satisfactions = board.getSatisfaction();
            this.createdDate = board.getCreatedAt();

        }
    }

}
