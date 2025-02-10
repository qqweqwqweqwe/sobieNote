package YUN.sobieNote.Report.DTO;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportGetResponse {

    private String result;
    private String msg;
    private List<Data> data;


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Data{
        private String keyword;
        private long value;  // count 수

    }


}
