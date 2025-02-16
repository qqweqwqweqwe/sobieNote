package YUN.sobieNote.Board.Repository;

import YUN.sobieNote.Board.Entity.Board;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardCustomRepository {

    public List<Board> findBoards(int memberId, Integer year, Integer month);

}