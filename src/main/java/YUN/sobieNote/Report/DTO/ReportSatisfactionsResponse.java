package YUN.sobieNote.Report.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ReportSatisfactionsResponse extends ReportGetResponse {

    public ReportSatisfactionsResponse(List<Data> data){
        super(data);
    }
}
