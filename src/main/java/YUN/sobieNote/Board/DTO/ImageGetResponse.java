package YUN.sobieNote.Board.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ImageGetResponse {
    private String result;
    private String msg;
    private Data data;


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data {
        private String contents;
        private Date createdDate;
        private String categories;
        private String emotions;
        private long satisfactions;
        private String factors;

    }

}
