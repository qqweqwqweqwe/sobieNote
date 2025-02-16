package YUN.sobieNote.Report.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ReportCategoryGetResponse extends ReportGetResponse{
    public ReportCategoryGetResponse(List<Data> data) {
        super(data);
    }
}
