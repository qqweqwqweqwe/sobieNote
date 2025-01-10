package YUN.sobieNote.Board.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImageGetResponseByMember {

    private String result;
    private String msg;
    private Data data;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Data{
        List<String> imagePath;
    }
}
