package YUN.sobieNote.Report.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReportCategoryGetResponse extends ReportGetResponse{
    public ReportCategoryGetResponse(String result, String msg, List<Data> data) {
        super(result,msg,data);
    }
}
