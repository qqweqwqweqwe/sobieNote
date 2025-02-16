package YUN.sobieNote.Goal.Controller;


import YUN.sobieNote.Global.DTO.ApiResponse;
import YUN.sobieNote.Goal.DTO.GoalGetResponse;
import YUN.sobieNote.Goal.DTO.GoalPostRequest;
import YUN.sobieNote.Goal.DTO.GoalPostResponse;
import YUN.sobieNote.Goal.Service.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/goal")
@RequiredArgsConstructor
public class GoalController {

    private final GoalService goalService;
    @GetMapping("/{memberId}")
    public ResponseEntity<ApiResponse<GoalGetResponse>> getGoal(
            @PathVariable int memberId
    ){
            GoalGetResponse goalGetResponse = goalService.getGoalByMemberId(memberId);
            return ResponseEntity.ok()
                    .body(new ApiResponse<>("OK","Success",goalGetResponse));
    }

    @PostMapping("/{memberId}")
    public ResponseEntity<ApiResponse<GoalPostResponse>> modifyGoal(
            @PathVariable int memberId,
            @RequestBody GoalPostRequest goalPostRequest
            ){

        System.out.println("dasd");
        System.out.println(goalPostRequest.getMission());
        GoalPostResponse goalPostResponse = goalService.updateGoalByMemberId(memberId, goalPostRequest.getMission());

        return ResponseEntity.ok()
                .body(new ApiResponse<GoalPostResponse>("OK", "Success", goalPostResponse));

    }

}
