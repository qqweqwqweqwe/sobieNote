package YUN.sobieNote.Board.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardPostRequest extends BoardRequest{


    private MultipartFile attachFile;

    public BoardPostRequest(BoardRequest boardRequest, MultipartFile attachFile) {
        super(boardRequest);
        this.attachFile = attachFile;
    }

}
