package YUN.sobieNote.Board.Repository;

import YUN.sobieNote.Board.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BoardRepository extends JpaRepository<Board,Integer> {
    List<Board> findByMemberIdAndCreatedAtYearAndCreatedAtMonth(int year, int month,int memberId);


}
