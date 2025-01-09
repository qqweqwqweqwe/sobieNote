package YUN.sobieNote.Board.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardPostRequest extends BoardRequest{

    private MultipartFile attachFile;

}
