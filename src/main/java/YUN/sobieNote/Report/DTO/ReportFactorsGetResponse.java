package YUN.sobieNote.Report.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ReportFactorsGetResponse extends ReportGetResponse {


    public ReportFactorsGetResponse(List<Data> data) {
        super(data);
    }
}
