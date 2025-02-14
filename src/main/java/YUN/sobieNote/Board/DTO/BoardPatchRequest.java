package YUN.sobieNote.Board.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardPatchRequest extends BoardRequest{

    private MultipartFile attachFile;

    public BoardPatchRequest(BoardRequest boardRequest, MultipartFile attachFile) {
        super(boardRequest);
        this.attachFile = attachFile;
    }
}