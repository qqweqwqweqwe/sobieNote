package YUN.sobieNote.Board.Controller;


import YUN.sobieNote.Board.DTO.BoardPatchResponse;
import YUN.sobieNote.Board.DTO.BoardPostResponse;
import YUN.sobieNote.Board.DTO.BoardRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {

    /**
     * 게시판에 피드 내용을 추가하는 함수입니다
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

        return ResponseEntity.ok()
                .body(new BoardPostResponse("result", "msg", true));
    }

    @PatchMapping("/posting/{boardId}")
    @ResponseBody
    public ResponseEntity<BoardPatchResponse>patchPost(
            @PathVariable long boardId,
            @RequestBody BoardRequest request
            ){
        return  ResponseEntity.ok()
                .body(new BoardPatchResponse("result", "msg", true));
    }
}
