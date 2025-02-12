package YUN.sobieNote.Board.Repository;

import YUN.sobieNote.Board.Entity.Category;
import YUN.sobieNote.Board.Enum.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByDisplayName(String displayName);
    boolean existsByName(String displayName);
}
