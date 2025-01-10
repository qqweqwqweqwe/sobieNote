package YUN.sobieNote.Report.Controller;

import YUN.sobieNote.Report.DTO.CategoryReportGetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public ResponseEntity<CategoryReportGetResponse> getCategoryReport(
            @PathVariable long year,
            @PathVariable long month,
            @PathVariable long memberId

    ){
        CategoryReportGetResponse.Data data = new CategoryReportGetResponse.Data(
                "test",
                1);

        return ResponseEntity.ok()
                .body(new CategoryReportGetResponse(
                        "test",
                        "test",
                        data
                ));
    }
}
