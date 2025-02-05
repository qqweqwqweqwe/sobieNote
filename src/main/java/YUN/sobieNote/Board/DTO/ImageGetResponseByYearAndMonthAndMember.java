package YUN.sobieNote.Board.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImageGetResponseByYearAndMonthAndMember {

    private String result;
    private String msg;
    private Data data;

    public ImageGetResponseByYearAndMonthAndMember(List<String> imagePath,String result, String msg) {
        this.data = new Data(imagePath);
        this.msg = msg;
        this.result = result;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Data{
        List<String> imagePath;
    }
}
