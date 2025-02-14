package YUN.sobieNote.Board.Controller;


import YUN.sobieNote.Board.DTO.*;
import YUN.sobieNote.Board.Entity.Board;
import YUN.sobieNote.Board.Service.BoardService;
import YUN.sobieNote.Global.DTO.ApiResponse;
import YUN.sobieNote.Global.Exception.ErrorResponse;
import YUN.sobieNote.Member.Entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<ApiResponse<BoardGetResponse>> getPost(
            @PathVariable int boardId
    ){
        BoardGetResponse boardGetResponse = boardService.getPostById(boardId);
        ApiResponse<BoardGetResponse> apiResponse = new ApiResponse<>("OK", "Success",boardGetResponse);
        return ResponseEntity.ok(apiResponse);
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
    public ResponseEntity<ApiResponse<Integer>> createPost(
            @PathVariable int memberId,
            @RequestPart BoardRequest boardRequest,
            @RequestPart(value = "attachFile", required = false) MultipartFile attachFile
            ){
            BoardPostRequest boardPostRequest = new BoardPostRequest(
                    boardRequest,
                    attachFile
            );
            BoardPostResponse boardPostResponse = boardService.uploadPost(boardPostRequest,memberId);
            ApiResponse<Integer> apiResponse = new ApiResponse<Integer>("OK", "Success", boardPostResponse.getData());
            return ResponseEntity.ok()
                    .body(apiResponse);

    }


    /**
     * 피드를 수정합니다.
     * @param boardId // 게시글 id
     * @param boardRequest // 내용
     * @param attachFile // 이미지
     * @return BoardPatchResponse
     */
    @PatchMapping("/posting/{boardId}")
    @ResponseBody
    public ResponseEntity<ApiResponse<Integer>>patchPost(
            @PathVariable int boardId,
            @RequestPart BoardRequest boardRequest,
            @RequestPart(value = "attachFile", required = false) MultipartFile attachFile
            ){

        BoardPatchRequest boardPatchRequest = new BoardPatchRequest(boardRequest,attachFile);
        BoardPatchResponse boardPatchResponse = boardService.updatePost(boardId,boardPatchRequest);
        ApiResponse<Integer> apiResponse = new ApiResponse<>("Ok","Success",boardPatchResponse.getData());

        return ResponseEntity.ok()
                .body(apiResponse);

    }

    @DeleteMapping("/posting/{boardId}")
    @ResponseBody
    public ResponseEntity<ApiResponse<Integer>>deletePost(
            @PathVariable int boardId
    ){
        BoardDeleteResponse boardDeleteResponse = boardService.deletePost(boardId);
        ApiResponse<Integer> apiResponse = new ApiResponse<>("OK","Success",boardDeleteResponse.getData());
        return ResponseEntity.ok()
                .body(apiResponse);
    }
}
