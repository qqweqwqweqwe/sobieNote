package YUN.sobieNote.Report.Controller;

import YUN.sobieNote.Report.DTO.CategoryMonthReportGetResponse;
import YUN.sobieNote.Report.DTO.EmotionsMonthReportGetResponse;
import YUN.sobieNote.Report.DTO.FactorsMonthReportGetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/report")
@Controller
public class ReportController {

    /**
     * 구매 카테고리를 조회합니다.
     * @param year
     * @param month
     * @param memberId
     * @return
     */
    @GetMapping("/categories/{year}/{month}/{memberId}")
    @ResponseBody
    public ResponseEntity<CategoryMonthReportGetResponse> getCategoryMonthReport(
            @PathVariable long year,
            @PathVariable long month,
            @PathVariable long memberId

    ){
        CategoryMonthReportGetResponse.Data data = new CategoryMonthReportGetResponse.Data(
                "test",
                1);

        return ResponseEntity.ok()
                .body(new CategoryMonthReportGetResponse(
                        "test",
                        "test",
                        data
                ));
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
    public ResponseEntity<EmotionsMonthReportGetResponse> getEmotionsMonthReport(
            @PathVariable long year,
            @PathVariable long month,
            @PathVariable long memberId

    ){
        EmotionsMonthReportGetResponse.Data data = new EmotionsMonthReportGetResponse.Data(
                "test",
                1);
        return ResponseEntity.ok()
                .body(new EmotionsMonthReportGetResponse(
                        "test",
                        "test",
                        data
                ));
    }

    @GetMapping("/emotions/{year}/{month}/{memberId}")
    @ResponseBody
    public ResponseEntity<FactorsMonthReportGetResponse> getFactorsMonthReport(
            @PathVariable long year,
            @PathVariable long month,
            @PathVariable long memberId
    ){
        FactorsMonthReportGetResponse.Data data = new FactorsMonthReportGetResponse.Data(
                "test",
                1);
        return ResponseEntity.ok()
                .body(new FactorsMonthReportGetResponse(
                        "test",
                        "test",
                        data
                ));

    }

}
