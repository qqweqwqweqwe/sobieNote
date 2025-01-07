package YUN.sobieNote.Board.DTO;

import lombok.Getter;
import lombok.Setter;

public class BoardPostResponse {

    private BoardRequest boardRequest;
    private String result;
    private String msg;
    private boolean data;

    public BoardPostResponse(String result, String msg, boolean data) {
        this.result = result;
        this.msg = msg;
        this.data = data;

    }
}
