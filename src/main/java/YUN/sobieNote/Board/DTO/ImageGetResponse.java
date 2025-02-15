package YUN.sobieNote.Board.DTO;

import YUN.sobieNote.Board.Entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ImageGetResponse {
    private List<String> imagePath;
}
