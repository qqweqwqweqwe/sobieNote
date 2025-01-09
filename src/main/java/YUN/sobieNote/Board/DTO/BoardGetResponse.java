package YUN.sobieNote.Board.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardGetResponse {

    private String result;
    private String msg;
    private Data data;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data {
        private Date createdDate;
        private String emotions;
        private long satisfactions;
        private String categories;
        private String factors;
        private String contents;
    }

}
