package YUN.sobieNote.Goal.Repository;

import YUN.sobieNote.Goal.Entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal,Integer> {


}
