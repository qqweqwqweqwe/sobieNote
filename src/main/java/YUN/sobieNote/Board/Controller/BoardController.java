package YUN.sobieNote.Board.Controller;


import YUN.sobieNote.Board.DTO.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
     * 게시판에 피드 내용을 추가하는 API입니다
     * @param memberId
     * @param request
     * @return
     */
    @PostMapping("/posting/{memberId}")
    @ResponseBody
    public ResponseEntity<BoardPostResponse> createPost(
            @PathVariable long memberId,
            @RequestBody BoardRequest request
            ){

        BoardPostResponse boardPostResponse = new BoardPostResponse();
        return ResponseEntity.ok()
                .body(boardPostResponse);
    }

    /**
     * 피드에 내용을 추가하는 API입니다.
     * @param boardId
     * @param request
     * @return
     */
    @PatchMapping("/posting/{boardId}")
    @ResponseBody
    public ResponseEntity<BoardPatchResponse>patchPost(
            @PathVariable long boardId,
            @RequestBody BoardRequest request
            ){
        return  ResponseEntity.ok()
                .body(new BoardPatchResponse("result", "msg", true));
    }

//    @DeleteMapping("/")
//    public ResponseEntity
}
