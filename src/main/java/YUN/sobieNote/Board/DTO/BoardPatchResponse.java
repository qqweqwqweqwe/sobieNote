package YUN.sobieNote.Board.DTO;

public class BoardPatchResponse {

    private String result;
    private String msg;
    private boolean data;


    public BoardPatchResponse(String result, String msg, boolean data){
        this.result = result;
        this.msg = msg;
        this.data = data;
    }

}
