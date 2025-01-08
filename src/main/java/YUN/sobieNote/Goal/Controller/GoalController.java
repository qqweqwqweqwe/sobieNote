package YUN.sobieNote.Goal.Controller;


import YUN.sobieNote.Goal.DTO.GoalGetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goal")
public class GoalController {

    @GetMapping("/{memberId}")
    public ResponseEntity<GoalGetResponse> getGoal(
            @PathVariable long memberId
    ){
        return ResponseEntity.ok()
                .body(new GoalGetResponse());
    }

    @PostMapping("/{memberId}")
    public ResponseEntity<GoalGetResponse> modifyGoal(
            @PathVariable long memberId
    ){
        return ResponseEntity.ok()
                .body(new GoalGetResponse());
    }

}
