package YUN.sobieNote.Report.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReportEmotionsMonthGetResponse {

    private String result;
    private String msg;
    private Data data;


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Data{
        private String keyword;
        private long value;

    }

}
