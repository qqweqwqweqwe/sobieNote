package YUN.sobieNote.Goal.DTO;

import YUN.sobieNote.Goal.Entity.Goal;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GoalGetResponse {
    private String result;
    private String msg;
    private String data;


    public GoalGetResponse(Goal goal,String result, String msg) {
        this.data = goal.getContents();
        this.result = result;
        this.msg = msg;
    }

    public GoalGetResponse(Goal goal) {
        this.data = goal.getContents();
        this.result = "OK";
        this.msg = "Success";
    }
}
