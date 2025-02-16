package YUN.sobieNote.Goal.Service;

import YUN.sobieNote.Goal.DTO.GoalGetResponse;
import YUN.sobieNote.Goal.DTO.GoalPostResponse;
import YUN.sobieNote.Goal.Entity.Goal;
import YUN.sobieNote.Goal.Repository.GoalRepository;
import YUN.sobieNote.Member.Entity.Member;
import YUN.sobieNote.Member.Repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class GoalService {
    private final GoalRepository goalRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public GoalGetResponse getGoalByMemberId(int memberId){
        Goal goal = goalRepository.findByMemberId(memberId)
                .orElseThrow(()-> new EntityNotFoundException("해당 유저의 목표를 찾을 수 없습니다 memberId: " +memberId ));

        return new GoalGetResponse(goal.getContents());

    }

    @Transactional
    public GoalPostResponse updateGoalByMemberId(int memberId, String mission){
        Goal goal = goalRepository.save(Goal.builder()
                .member(memberRepository.findById(memberId)
                        .orElseThrow(() ->new EntityNotFoundException("해당 유저가 존재하지 않습니다")))
                .contents(mission)
                .build());

        return new GoalPostResponse(goal);
    }

}
