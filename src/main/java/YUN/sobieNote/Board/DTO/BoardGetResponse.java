package YUN.sobieNote.Board.DTO;

import java.util.Date;

public class BoardGetResponse {

    private String result;
    private String msg;
    private Data data;


    private class Data {
        private Date createdDate;
        private String emotions;
        private long satisfactions;
        private String categories;
        private String factors;
        private String contents;
    }

}
