package YUN.sobieNote.Board.Repository;

import YUN.sobieNote.Board.Entity.Emotion;
import YUN.sobieNote.Board.Entity.Factor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FactorRepository extends JpaRepository<Factor,Integer> {
    Optional<Factor> findByDisplayName(String displayName);
    boolean existsByName(String displayName);

}
