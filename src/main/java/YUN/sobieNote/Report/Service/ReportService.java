package YUN.sobieNote.Report.Service;


import YUN.sobieNote.Board.Entity.Board;
import YUN.sobieNote.Board.Service.BoardService;
import YUN.sobieNote.Report.DTO.ReportCategoryGetResponse;
import YUN.sobieNote.Report.DTO.ReportEmotionsGetResponse;
import YUN.sobieNote.Report.DTO.ReportFactorsGetResponse;
import YUN.sobieNote.Report.DTO.ReportGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final BoardService boardService;


    public ReportCategoryGetResponse getReportCategory(int memberId, int year, Integer month){
        try {
            List<Board> boards = boardService.getPosts(memberId, year, month);
            ReportCategoryGetResponse reportCategoryGetResponse = new ReportCategoryGetResponse();

            Map<String, Integer> categoryCount = new HashMap<>();

            for (Board bo : boards) {
                String category = bo.getCategory().getDisplayName();
                categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
            }

            for (String key : categoryCount.keySet()) {
                reportCategoryGetResponse.getData().add(new ReportGetResponse.Data(key, categoryCount.get(key)));
            }

            reportCategoryGetResponse.setMsg("Success");
            reportCategoryGetResponse.setResult("OK");
            return reportCategoryGetResponse;
        }catch (Exception e){
            return new ReportCategoryGetResponse("FAIL", "조회에 실패하였습니다 member Id : " + memberId + "error : " + e.getMessage(),null);
        }
    }

    public ReportEmotionsGetResponse getReportEmotions(int memberId, int year, Integer month){
        try {
            List<Board> boards = boardService.getPosts(memberId, year, month);
            ReportEmotionsGetResponse reportEmotionsGetResponse = new ReportEmotionsGetResponse();

            Map<String, Integer> emotionCount = new HashMap<>();

            for (Board bo : boards) {
                String Emotion = bo.getEmotion().getDisplayName();
                emotionCount.put(Emotion, emotionCount.getOrDefault(Emotion, 0) + 1);
            }

            for (String key : emotionCount.keySet()) {
                reportEmotionsGetResponse.getData().add(new ReportGetResponse.Data(key, emotionCount.get(key)));
            }

            reportEmotionsGetResponse.setMsg("Success");
            reportEmotionsGetResponse.setResult("OK");
            return reportEmotionsGetResponse;
        }catch (Exception e){
            return new ReportEmotionsGetResponse("FAIL", "조회에 실패하였습니다 member Id : " + memberId + "error : " + e.getMessage(),null);
        }
    }

    public ReportFactorsGetResponse getReportFactors(int memberId, int year, Integer month){
        try {
            List<Board> boards = boardService.getPosts(memberId, year, month);
            ReportFactorsGetResponse reportFactorsGetResponse = new ReportFactorsGetResponse();

            Map<String, Integer> factorsCount = new HashMap<>();

            for (Board bo : boards) {
                String factor = bo.getFactor().getDisplayName();
                factorsCount.put(factor, factorsCount.getOrDefault(factor, 0) + 1);
            }

            for (String key : factorsCount.keySet()) {
                reportFactorsGetResponse.getData().add(new ReportGetResponse.Data(key, factorsCount.get(key)));
            }

            reportFactorsGetResponse.setMsg("Success");
            reportFactorsGetResponse.setResult("OK");
            return reportFactorsGetResponse;
        }catch (Exception e){
            return new ReportFactorsGetResponse("FAIL", "조회에 실패하였습니다 member Id : " + memberId + "error : " + e.getMessage(),null);
        }
    }


}
