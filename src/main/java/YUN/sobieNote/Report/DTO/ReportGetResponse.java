package YUN.sobieNote.Report.DTO;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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
