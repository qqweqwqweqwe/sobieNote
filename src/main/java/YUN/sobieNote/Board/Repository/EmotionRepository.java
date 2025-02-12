package YUN.sobieNote.Board.Repository;

import YUN.sobieNote.Board.Entity.Category;
import YUN.sobieNote.Board.Entity.Emotion;
import YUN.sobieNote.Board.Enum.CategoryType;
import YUN.sobieNote.Board.Enum.EmotionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmotionRepository extends JpaRepository<Emotion, Integer> {
    Optional<Emotion> findByDisplayName(String displayName);
    boolean existsByName(String displayName);

}
