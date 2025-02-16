package YUN.sobieNote.Report.Service;


import YUN.sobieNote.Board.Entity.Board;
import YUN.sobieNote.Board.Service.BoardService;
import YUN.sobieNote.Report.DTO.*;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
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

            return reportCategoryGetResponse;
        }catch (Exception e){
            throw new InternalException(e.getMessage());
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

            return reportEmotionsGetResponse;
        }catch (Exception e){
            return new ReportEmotionsGetResponse(null);
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

            return reportFactorsGetResponse;
        }catch (Exception e){
            return new ReportFactorsGetResponse(null);
        }
    }


    public ReportSatisfactionsResponse getReportSatisfactions(int memberId, int year, Integer month){
        try {
            List<Board> boards = boardService.getPosts(memberId, year, month);
            ReportSatisfactionsResponse reportSatisfactionsResponse = new ReportSatisfactionsResponse();

            Map<Integer, Integer> factorsCount = new HashMap<>();

            for (Board bo : boards) {
                int satisfaction = (int) bo.getSatisfaction();
                factorsCount.put(satisfaction, factorsCount.getOrDefault(satisfaction, 0) + 1);
            }

            for (int key : factorsCount.keySet()) {
                reportSatisfactionsResponse.getData().add(new ReportSatisfactionsResponse.Data(String.valueOf(key), factorsCount.get(key)));
            }

            return reportSatisfactionsResponse;
        }catch (Exception e){
            return new ReportSatisfactionsResponse(null);
        }
    }




}
