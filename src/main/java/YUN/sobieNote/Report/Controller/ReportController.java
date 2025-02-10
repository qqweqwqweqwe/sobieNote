package YUN.sobieNote.Report.Controller;

import YUN.sobieNote.Board.Service.BoardService;
import YUN.sobieNote.Report.DTO.ReportCategoryGetResponse;
import YUN.sobieNote.Report.DTO.ReportEmotionsGetResponse;
import YUN.sobieNote.Report.DTO.ReportEmotionsMonthGetResponse;
import YUN.sobieNote.Report.DTO.ReportFactorsMonthGetResponse;
import YUN.sobieNote.Report.Service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;
    private final BoardService boardService;

    /**
     * 구매 카테고리를 조회합니다.
     * @param year
     * @param month
     * @param memberId
     * @return
     */
    @GetMapping("/categories/{year}/{month}/{memberId}")
    @ResponseBody
    public ResponseEntity<ReportCategoryGetResponse> getCategoryReport(
            @PathVariable int year,
            @PathVariable int month,
            @PathVariable int memberId

    ){
        // todo 이거 예외처리 나중에 전역 예외 처리로 바꿀거
        try {
            ReportCategoryGetResponse reportCategoryGetResponse = reportService.getReportCategory(memberId,year,month);

            return ResponseEntity.ok()
                    .body(reportCategoryGetResponse);
        }
        catch (Exception e){
            return ResponseEntity.ok()
                    .body(new ReportCategoryGetResponse("FAIL", "조회실패", null));
        }
    }

    @GetMapping("/categories/{year}/{memberId}")
    @ResponseBody
    public ResponseEntity<ReportCategoryGetResponse> getCategoryReport(
            @PathVariable int year,
            @PathVariable int memberId

    ){
        try {
            ReportCategoryGetResponse reportCategoryGetResponse = reportService.getReportCategory(memberId,year,null);

            return ResponseEntity.ok()
                    .body(reportCategoryGetResponse);
        }
        catch (Exception e){
            return ResponseEntity.ok()
                    .body(new ReportCategoryGetResponse("FAIL", "조회실패", null));
        }

    }



    /**
     * 구매 감정을 조회합니다.
     * @param year
     * @param month
     * @param memberId
     * @return
     */
    @GetMapping("/emotions/{year}/{month}/{memberId}")
    @ResponseBody
    public ResponseEntity<ReportEmotionsGetResponse> getEmotionsReport(
            @PathVariable int year,
            @PathVariable int month,
            @PathVariable int memberId

    ){
        try {
            ReportEmotionsGetResponse reportEmotionsGetResponse = reportService.getReportEmotions(memberId,year,month);

            return ResponseEntity.ok()
                    .body(reportEmotionsGetResponse);
        }
        catch (Exception e){
            return ResponseEntity.ok()
                    .body(new ReportEmotionsGetResponse("FAIL", "조회실패", null));
        }
    }

    @GetMapping("/emotions/{year}/{memberId}")
    @ResponseBody
    public ResponseEntity<ReportEmotionsGetResponse> getEmotionsReport(
            @PathVariable int year,
            @PathVariable int memberId

    ){
        try {
            ReportEmotionsGetResponse reportEmotionsGetResponse = reportService.getReportEmotions(memberId,year,null);

            return ResponseEntity.ok()
                    .body(reportEmotionsGetResponse);
        }
        catch (Exception e){
            return ResponseEntity.ok()
                    .body(new ReportEmotionsGetResponse("FAIL", "조회실패", null));
        }
    }

}
