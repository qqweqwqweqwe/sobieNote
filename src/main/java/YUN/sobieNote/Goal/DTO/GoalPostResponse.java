package YUN.sobieNote.Goal.DTO;

import YUN.sobieNote.Goal.Entity.Goal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class GoalPostResponse {
    private String msg;
    private int goalId;
    private int year;
    private int month;
    private int memberId;

    public GoalPostResponse(Goal goal) {
        this.msg = "Success";
        this.goalId = goal.getId();
        this.year = goal.getYear();
        this.month = goal.getMonth();
        this.memberId = goal.getMember().getId();
    }

    public GoalPostResponse(Goal goal, String msg, int memberId) {
        this.msg = msg;
        this.goalId = -1;
        this.year = -1;
        this.month = -1;
        this.memberId = memberId;
    }
}
