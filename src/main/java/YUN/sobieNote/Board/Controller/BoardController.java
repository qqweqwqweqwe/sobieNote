package YUN.sobieNote.Board.Controller;


import YUN.sobieNote.Board.DTO.*;
import YUN.sobieNote.Board.Service.BoardService;
import YUN.sobieNote.Global.Exception.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    /**
     * 피드 내용을 조회합니다.
     * @return BoardGetResponse
     */
    @GetMapping("/posting/{boardId}")
    @ResponseBody
    public ResponseEntity<?> getPost(
            @PathVariable int boardId
    ){
        try {
            BoardGetResponse boardGetResponse =boardService.getPostById(boardId);
            return ResponseEntity.ok()
                    .body(boardGetResponse);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getClass().getSimpleName(), e.getMessage()));
        }
    }


    /**
     * 피드를 작성합니다
     * @param memberId // 작성자 id
     * @param boardRequest // 내용
     * @param attachFile // 이미지
     * @return BoardPostResponse
     */
    @PostMapping("/posting/{memberId}")
    @ResponseBody
    public ResponseEntity<?> createPost(
            @PathVariable int memberId,
            @RequestPart BoardRequest boardRequest,
            @RequestPart(value = "attachFile", required = false) MultipartFile attachFile
            ){
        try {
            BoardPostRequest boardPostRequest = new BoardPostRequest(
                    boardRequest,
                    attachFile
            );
            BoardPostResponse boardPostResponse = boardService.uploadPost(boardPostRequest,memberId);
            return ResponseEntity.ok()
                    .body(boardPostResponse);
        }catch (Exception e){
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse(e.getClass().getSimpleName(), e.getMessage()));
        }

    }


    /**
     *
     * @param boardId // 게시글 id
     * @param boardRequest // 내용
     * @param attachFile // 이미지
     * @return BoardPatchResponse
     */
    @PatchMapping("/posting/{boardId}")
    @ResponseBody
    public ResponseEntity<BoardPatchResponse>patchPost(
            @PathVariable long boardId,
            @RequestPart BoardRequest boardRequest,
            @RequestPart(value = "attachFile", required = false) MultipartFile attachFile
            ){
        return  ResponseEntity.ok()
                .body(new BoardPatchResponse(
                        "result",
                        "msg",
                        "1"));
    }

    @DeleteMapping("/posting/{boardId}")
    @ResponseBody
    public ResponseEntity<BoardDeleteResponse>deletePost(
            @PathVariable long boardId
    ){
        return ResponseEntity.ok()
                .body(new BoardDeleteResponse(
                        "result",
                        "msg",
                        "1"
                ));
    }
}
