package YUN.sobieNote.Goal.Service;

import YUN.sobieNote.Goal.DTO.GoalGetResponse;
import YUN.sobieNote.Goal.Entity.Goal;
import YUN.sobieNote.Goal.Repository.GoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoalService {
    private final GoalRepository goalRepository;

    public GoalGetResponse getGoalByMemberId(int memberId){
        Goal goal = goalRepository.findById(memberId)
                .orElseThrow(()-> new IllegalArgumentException("해당 목표를 찾을 수 없습니다 memberId: " +memberId ));

        return new GoalGetResponse(goal);



    }

}
