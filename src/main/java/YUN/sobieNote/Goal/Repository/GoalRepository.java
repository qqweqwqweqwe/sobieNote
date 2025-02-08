package YUN.sobieNote.Goal.Repository;

import YUN.sobieNote.Goal.Entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoalRepository extends JpaRepository<Goal,Integer> {

    Optional<Goal> findByMemberId(int memberId);
}
