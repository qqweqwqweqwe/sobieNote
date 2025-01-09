package YUN.sobieNote.Board.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardPatchResponse {

    private String result;
    private String msg;
    private String data;

}
