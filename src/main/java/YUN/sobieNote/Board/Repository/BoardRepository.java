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

//     작성한 게시글을 가져오는 쿼리
    @Query(value = "SELECT * FROM Boards b WHERE " +
            "(:memberId IS NULL OR b.member_id = :memberId) " +
            "AND (:year IS NULL OR YEAR(b.created_at)= :year) " +
            "AND (:month IS NULL OR MONTH(b.created_at) = :month)", nativeQuery = true)
    Optional<List<Board>> findBoards(
            @Param("memberId") Integer memberId,
            @Param("year") Integer year,
            @Param("month") Integer month
    );





    }
