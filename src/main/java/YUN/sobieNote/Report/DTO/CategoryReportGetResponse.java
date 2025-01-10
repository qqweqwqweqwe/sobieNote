package YUN.sobieNote.Report.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryReportGetResponse {
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
