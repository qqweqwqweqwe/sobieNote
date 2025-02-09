package YUN.sobieNote.Goal.Service;

import YUN.sobieNote.Goal.DTO.GoalGetResponse;
import YUN.sobieNote.Goal.DTO.GoalPostResponse;
import YUN.sobieNote.Goal.Entity.Goal;
import YUN.sobieNote.Goal.Repository.GoalRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class GoalService {
    private final GoalRepository goalRepository;

    public GoalGetResponse getGoalByMemberId(int memberId){
        Goal goal = goalRepository.findByMemberId(memberId)
                .orElseThrow(()-> new IllegalArgumentException("해당 유저의 목표를 찾을 수 없습니다 memberId: " +memberId ));

        return new GoalGetResponse(goal);

    }

    public GoalPostResponse updateGoalByMemberId(int memberId, String mission){
        Goal goal = goalRepository.findByMemberId(memberId)
                .orElseThrow(()-> new IllegalArgumentException("해당 유저의 목표를 찾을 수 없습니다. memberId: " +memberId ));

        goal.updateContents(mission);

        return new GoalPostResponse(goal);
    }

}
