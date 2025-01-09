package YUN.sobieNote.Board.Controller;


import YUN.sobieNote.Board.DTO.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Controller
@RequestMapping("/board")
public class BoardController {

    /**
     * 피드 내용을 조회합니다.
     * @return BoardGetResponse
     */
    @GetMapping("/posting/{boardId}")
    @ResponseBody
    public ResponseEntity<BoardGetResponse> getPost(
            @PathVariable long boardId
    ){
        // boardId로 조회
        //  return entity to dto
        BoardGetResponse.Data data = new BoardGetResponse.Data(
                new Date(),
                "test",
                1,
                "test",
                "test",
                "test"
        );
        BoardGetResponse boardGetResponse = new BoardGetResponse(
                "test",
                "test",
                data
        );

        return ResponseEntity.ok()
                .body(boardGetResponse);
    }


    /**
     * 피드를 작성합니다
     * @param boardId // 게시글 Id
     * @param boardRequest // 내용
     * @param attachFile // 이미지
     * @return BoardPostResponse
     */
    @PostMapping("/posting/{boardId}")
    @ResponseBody
    public ResponseEntity<BoardPostResponse> createPost(
            @PathVariable long boardId,
            @RequestPart BoardRequest boardRequest,
            @RequestPart(value = "attachFile", required = false) MultipartFile attachFile
            ){

        BoardPostResponse boardPostResponse = new BoardPostResponse(
                "test",
                "test",
                "1"
        );
        return ResponseEntity.ok()
                .body(boardPostResponse);
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
