package YUN.sobieNote.Report.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class ReportEmotionsGetResponse extends ReportGetResponse{


    public ReportEmotionsGetResponse(List<Data> data) {
        super(data);
    }
}
