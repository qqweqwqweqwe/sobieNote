package YUN.sobieNote.Report.Controller;

import YUN.sobieNote.Board.Service.BoardService;
import YUN.sobieNote.Global.DTO.ApiResponse;
import YUN.sobieNote.Report.DTO.ReportCategoryGetResponse;
import YUN.sobieNote.Report.DTO.ReportEmotionsGetResponse;
import YUN.sobieNote.Report.DTO.ReportFactorsGetResponse;
import YUN.sobieNote.Report.DTO.ReportSatisfactionsResponse;
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
    public ResponseEntity<ApiResponse<ReportCategoryGetResponse>> getCategoryReport(
            @PathVariable int year,
            @PathVariable int month,
            @PathVariable int memberId

    ){
        ReportCategoryGetResponse reportCategoryGetResponse = reportService.getReportCategory(memberId,year,month);

        return ResponseEntity.ok()
                .body(new ApiResponse<>("OK","Success",reportCategoryGetResponse));
    }

    @GetMapping("/categories/{year}/{memberId}")
    @ResponseBody
    public ResponseEntity<ApiResponse<ReportCategoryGetResponse>> getCategoryReport(
            @PathVariable int year,
            @PathVariable int memberId

    ){
        ReportCategoryGetResponse reportCategoryGetResponse = reportService.getReportCategory(memberId,year,null);

        return ResponseEntity.ok()
                .body(new ApiResponse<>("OK","Success",reportCategoryGetResponse));

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
    public ResponseEntity<ApiResponse<ReportEmotionsGetResponse>> getEmotionsReport(
            @PathVariable int year,
            @PathVariable int month,
            @PathVariable int memberId

    ){
            ReportEmotionsGetResponse reportEmotionsGetResponse = reportService.getReportEmotions(memberId,year,month);

            return ResponseEntity.ok()
                    .body(new ApiResponse<>("OK","Success",reportEmotionsGetResponse));
    }

    @GetMapping("/emotions/{year}/{memberId}")
    @ResponseBody
    public ResponseEntity<ApiResponse<ReportEmotionsGetResponse>> getEmotionsReport(
            @PathVariable int year,
            @PathVariable int memberId

    ){
        ReportEmotionsGetResponse reportEmotionsGetResponse = reportService.getReportEmotions(memberId,year,null);

        return ResponseEntity.ok()
                .body(new ApiResponse<>("OK","Success",reportEmotionsGetResponse));
    }

    /**
     * 구매 요인을 조회합니다.
     * @param year
     * @param month
     * @param memberId
     * @return
     */
    @GetMapping("/factors/{year}/{month}/{memberId}")
    @ResponseBody
    public ResponseEntity<ApiResponse<ReportFactorsGetResponse>> getFactorsReport(
            @PathVariable int year,
            @PathVariable int month,
            @PathVariable int memberId

    ){
        ReportFactorsGetResponse reportFactorsGetResponse = reportService.getReportFactors(memberId,year,month);
        return ResponseEntity.ok()
                .body(new ApiResponse<>("Ok","Success", reportFactorsGetResponse));
    }

    @GetMapping("/factors/{year}/{memberId}")
    @ResponseBody
    public ResponseEntity<ApiResponse<ReportFactorsGetResponse>> getFactorsReport(
            @PathVariable int year,
            @PathVariable int memberId

    ){
        ReportFactorsGetResponse reportFactorsGetResponse = reportService.getReportFactors(memberId,year,null);
        return ResponseEntity.ok()
                .body(new ApiResponse<>("Ok","Success", reportFactorsGetResponse));
    }


    @GetMapping("/satisfactions/{year}/{month}/{memberId}")
    @ResponseBody
    public ResponseEntity<ApiResponse<ReportSatisfactionsResponse>> getSatisfactionsReport(
            @PathVariable int year,
            @PathVariable int month,
            @PathVariable int memberId

    ){
        ReportSatisfactionsResponse reportSatisfactionsResponse = reportService.getReportSatisfactions(memberId,year,month);
        return ResponseEntity.ok()
                .body(new ApiResponse<>("Ok","Success", reportSatisfactionsResponse));
    }


    @GetMapping("/satisfactions/{year}/{memberId}")
    @ResponseBody
    public ResponseEntity<ApiResponse<ReportSatisfactionsResponse>> getSatisfactionsReport(
            @PathVariable int year,
            @PathVariable int memberId

    ){
        ReportSatisfactionsResponse reportSatisfactionsResponse = reportService.getReportSatisfactions(memberId,year,null);
        return ResponseEntity.ok()
                .body(new ApiResponse<>("Ok","Success", reportSatisfactionsResponse));
    }


    @GetMapping("/satisfactions/avg/{year}/{month}/{memberId}")
    @ResponseBody
    public ResponseEntity<ApiResponse<Integer>> getAvgSatisfactionsReport(
            @PathVariable int year,
            @PathVariable int month,
            @PathVariable int memberId

    ){
        int avg = reportService.getReportAverageSatisfactions(memberId,year,month);
        return ResponseEntity.ok()
                .body(new ApiResponse<>("Ok","Success", avg));
    }


    @GetMapping("/satisfactions/avg/{year}/{memberId}")
    @ResponseBody
    public ResponseEntity<ApiResponse<Integer>> getAvgSatisfactionsReport(
            @PathVariable int year,
            @PathVariable int memberId

    ){
        int avg = reportService.getReportAverageSatisfactions(memberId,year,null);
        return ResponseEntity.ok()
                .body(new ApiResponse<>("Ok","Success", avg));
    }


}
