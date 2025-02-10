package YUN.sobieNote.Report.Service;


import YUN.sobieNote.Board.Entity.Board;
import YUN.sobieNote.Board.Service.BoardService;
import YUN.sobieNote.Report.DTO.ReportCategoryGetResponse;
import YUN.sobieNote.Report.DTO.ReportGetResponse;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ReportService {

    private final BoardService boardService;


    public ReportCategoryGetResponse getReportCategory(int memberId, int year, Integer month){
        try {
            List<Board> boards = boardService.getPosts(memberId, year, month);
            ReportCategoryGetResponse reportCategoryGetResponse = new ReportCategoryGetResponse();

            Map<String, Integer> categoryCount = new HashMap<>();

            for (Board bo : boards) {
                String category = bo.getCategory().getType().name();
                categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
            }

            for (String key : categoryCount.keySet()) {
                reportCategoryGetResponse.getData().add(new ReportGetResponse.Data(key, categoryCount.get(key)));
            }

            reportCategoryGetResponse.setMsg("Success");
            reportCategoryGetResponse.setResult("OK");
            return reportCategoryGetResponse;
        }catch (Exception e){
            return new ReportCategoryGetResponse("FAIL", "조회에 실패하였습니다 member Id : " + memberId,null);
        }
    }
}
