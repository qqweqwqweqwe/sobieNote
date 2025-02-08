package YUN.sobieNote.Goal.DTO;

import YUN.sobieNote.Goal.Entity.Goal;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GoalGetResponse {
    private String result;
    private String msg;
    private String data;


    public GoalGetResponse(Goal goal,String msg, String data) {
        this.data = goal.getContents();
    }
}
