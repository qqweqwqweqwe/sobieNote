package YUN.sobieNote.Report.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReportEmotionsGetResponse extends ReportGetResponse{


    public ReportEmotionsGetResponse(String result, String msg, List<Data> data) {
        super(result,msg,data);
    }
}
