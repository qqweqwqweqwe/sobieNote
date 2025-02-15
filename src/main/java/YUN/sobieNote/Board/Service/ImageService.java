package YUN.sobieNote.Board.Service;

import YUN.sobieNote.Board.DTO.ImageGetResponse;
import YUN.sobieNote.Board.Entity.Board;
import YUN.sobieNote.Board.Repository.BoardRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final BoardRepository boardRepository;



    public ImageGetResponse getImageByBoardId(int boardId){
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시글을 찾을 수 없습니다. ID: " + boardId));

        List<String> imageList = new ArrayList<>();
        imageList.add(board.getImageUrl());

        return new ImageGetResponse(imageList);
    }

    public ImageGetResponse getImageByDate(int year, int month, int memberId){
        List<Board> boards = boardRepository.findBoards(memberId,year,month)
                .orElseThrow(() -> new EntityNotFoundException("해당 날짜의 게시글이 없습니다. memberId: " + memberId + "year : " + year + "month : " + month ));
        List<String> imageList = new ArrayList<>();

        for (Board board : boards){
            imageList.add(board.getImageUrl());
        }

        return new ImageGetResponse(imageList);
    }


}
