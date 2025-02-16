package YUN.sobieNote.Report.DTO;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportGetResponse {
    // 명시적으로 생성해주어야함
    private List<Data> data = new ArrayList<>();  // ✅ 자동 초기화

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Data{
        private String keyword;
        private long value;  // count 수

    }


}
