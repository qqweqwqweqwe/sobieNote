package YUN.sobieNote.Board.Repository;

import YUN.sobieNote.Board.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BoardRepository extends JpaRepository<Board,Integer> {
    List<Board> findByMemberIdAndCreatedAtYearAndCreatedAtMonth(int year, int month,int memberId);

    @Query("SELECT b FROM Board b WHERE " +
            "(:memberId IS NULL OR b.memberId = :memberId) " +
            "AND (:year IS NULL OR FUNCTION('YEAR', b.createdAtYear) = :year) " +
            "AND (:month IS NULL OR FUNCTION('MONTH', b.createdAtMonth) = :month)")
    Optional<List<Board>> findBoards(
            @Param("memberId") Integer memberId,
            @Param("year") Integer year,
            @Param("month") Integer month
    );



}
