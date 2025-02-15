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
    private String imagePath;
}
