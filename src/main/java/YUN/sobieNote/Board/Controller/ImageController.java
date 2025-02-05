package YUN.sobieNote.Board.Controller;


import YUN.sobieNote.Board.DTO.ImageGetResponse;
import YUN.sobieNote.Board.DTO.ImageGetResponseByMember;
import YUN.sobieNote.Board.Entity.Board;
import YUN.sobieNote.Board.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RequestMapping("image")
@Controller
@ResponseBody
@RequiredArgsConstructor
public class ImageController {

    private final BoardService boardService;

    /**
     * 이미지를 조회합니다.
     * @param boardId 게시글 Id
     * @return ImageGetResponse
     */
    @GetMapping("/{boardId}")
    public ResponseEntity<ImageGetResponse> getImage(
            @PathVariable int boardId
    ){
        try {
            Board board = boardService.getPostById(boardId);
            ImageGetResponse imageGetResponse = new ImageGetResponse(board,"OK","Success");
            return ResponseEntity.ok()
                    .body(imageGetResponse);
        }catch (Exception e){
            return ResponseEntity.ok()
                    .body(new ImageGetResponse(null, "FAIL", e.getMessage()));

        }

    }

    @GetMapping("/{year}/{month}/{memberId}")
    public ResponseEntity<ImageGetResponseByMember> getImageByMember(
            @PathVariable long year,
            @PathVariable long month,
            @PathVariable long memberId
    ){
        ImageGetResponseByMember.Data data= new ImageGetResponseByMember.Data(new ArrayList<String>(List.of(new String[]{"test"})));
        return ResponseEntity.ok()
                .body(new ImageGetResponseByMember(
                        "test",
                        "test",
                        data
                        ));
    }

}
