package YUN.sobieNote.Board.Service;

import YUN.sobieNote.Board.DTO.BoardDeleteResponse;
import YUN.sobieNote.Board.DTO.BoardGetResponse;
import YUN.sobieNote.Board.DTO.BoardPostRequest;
import YUN.sobieNote.Board.DTO.BoardPostResponse;
import YUN.sobieNote.Board.Entity.Board;

import YUN.sobieNote.Board.Entity.Category;
import YUN.sobieNote.Board.Entity.Emotion;
import YUN.sobieNote.Board.Entity.Factor;
import YUN.sobieNote.Board.Enum.CategoryType;
import YUN.sobieNote.Board.Enum.EnumConverter;
import YUN.sobieNote.Board.Repository.BoardRepository;
import YUN.sobieNote.Board.Repository.CategoryRepository;
import YUN.sobieNote.Board.Repository.EmotionRepository;
import YUN.sobieNote.Board.Repository.FactorRepository;
import YUN.sobieNote.Member.Entity.Member;
import YUN.sobieNote.Member.Repository.MemberRepository;
import YUN.sobieNote.Report.DTO.ReportCategoryGetResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;
    private final EmotionRepository emotionRepository;
    private final FactorRepository factorRepository;
    private final MemberRepository memberRepository;


    public BoardGetResponse getPostById(int id){
        Board board =  boardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시글을 찾을 수 없습니다. ID: " + id));

        return new BoardGetResponse(board);

    }

    public List<Board> getPosts(Integer memberId, Integer year, Integer month){
        List<Board> boards = boardRepository.findBoards(memberId,year,month)
                .orElse(Collections.emptyList()); // optinal이 비어있으면 빈 리스트 반환

        if(boards.isEmpty()){
            throw new NoSuchElementException("게시글이 존재하지 않습니다");
        }

        return boards;

    }

    public Member getMemberOfPost(int id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. ID: " + id));
        return board.getMember();
    }

    public BoardPostResponse uploadPost(BoardPostRequest boardPostRequest,int memberId){

        Member member = memberRepository.findById(memberId)
                .orElseThrow(()->new EntityNotFoundException("해당 유저가 존재하지 않습니다. member: "+memberId));

        Category category = categoryRepository.findByDisplayName((boardPostRequest.getCategories()))
                .orElseThrow(() -> new EntityNotFoundException("해당 카테고리가 존재하지 않습니다. category: " + boardPostRequest.getCategories()));

        Emotion emotion = emotionRepository.findByDisplayName((boardPostRequest.getEmotions()))
                .orElseThrow(() -> new EntityNotFoundException("해당 감정이 존재하지 않습니다. emotion: " + boardPostRequest.getEmotions()));

        Factor factor = factorRepository.findByDisplayName((boardPostRequest.getFactors()))
                .orElseThrow(() -> new EntityNotFoundException("해당 구매 요인이 존재하지 않습니다. factor: " + boardPostRequest.getFactors()));

        Board board = new Board(boardPostRequest, emotion, category, factor, member);
        int boardId = boardRepository.save(board).getId();
        return new BoardPostResponse(boardId);
    }

//    public BoardDeleteResponse deletePost(int boardId){
//
//        try{
//
//            Board board = getPostById(boardId);
//            boardRepository.delete(board);
//            return new BoardDeleteResponse("OK","게시글을 삭제하였습니다. ID : " + boardId, null);
//
//        }catch (Exception e){
//            return new BoardDeleteResponse("FAIL",e.getMessage(), null);
//
//        }
//    }

    public List<String> getImagePaths(int year, int month, int memberId){

        List<Board> boardList = boardRepository.findByMemberIdAndCreatedAtYearAndCreatedAtMonth(year,month,memberId);
        List<String> imagePaths = new ArrayList<>();
        for(Board board : boardList){
            imagePaths.add(board.getImageUrl());

        }

        return  imagePaths;

    }

}
