package YUN.sobieNote.Goal.Controller;


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
    public ResponseEntity<GoalGetResponse> getGoal(
            @PathVariable int memberId
    ){
        try {
            GoalGetResponse goalGetResponse = goalService.getGoalByMemberId(memberId);
            return ResponseEntity.ok()
                    .body(goalGetResponse);
        } catch (Exception e) {
            return  ResponseEntity.badRequest()
                    .body(new GoalGetResponse(null,"FAIL", e.getMessage()));
        }
    }

    @PostMapping("/{memberId}")
    public ResponseEntity<GoalPostResponse> modifyGoal(
            @PathVariable int memberId,
            @RequestBody GoalPostRequest goalPostRequest
            ){

        try {
            GoalPostResponse goalPostResponse = goalService.updateGoalByMemberId(memberId, goalPostRequest.getMission());
            return ResponseEntity.ok()
                    .body(goalPostResponse);
        }catch (Exception e){
            return ResponseEntity.badRequest()
                    .body(new GoalPostResponse(null,"FAIL",memberId));
        }

    }

}
