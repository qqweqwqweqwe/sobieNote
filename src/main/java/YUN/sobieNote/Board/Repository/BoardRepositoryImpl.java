package YUN.sobieNote.Board.Repository;

import YUN.sobieNote.Board.Entity.Board;
import YUN.sobieNote.Board.Entity.QBoard;
import YUN.sobieNote.Board.Entity.QCategory;
import com.querydsl.core.QueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardRepositoryImpl implements BoardCustomRepository{

    private final JPAQueryFactory queryFactory;
    @Override
    public List<Board> findBoards(int memberId, Integer year, Integer month) {

        QBoard board = QBoard.board;

        return queryFactory
                .select(board)
                .from(board)
                .where(
                        board.member.id.eq(memberId),
                        year != null ? board.createdAt.year().eq(year) : null,
                        month != null ? board.createdAt.month().eq(month) : null
                )
                .fetch();

    }
}
