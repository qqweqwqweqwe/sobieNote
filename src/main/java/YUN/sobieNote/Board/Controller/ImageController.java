package YUN.sobieNote.Board.Controller;


import YUN.sobieNote.Board.DTO.BoardGetResponse;
import YUN.sobieNote.Board.DTO.ImageGetResponse;
import YUN.sobieNote.Board.DTO.ImageGetResponseByYearAndMonthAndMember;
import YUN.sobieNote.Board.Entity.Board;
import YUN.sobieNote.Board.Service.BoardService;
import YUN.sobieNote.Board.Service.ImageService;
import YUN.sobieNote.Global.DTO.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@RequestMapping("image")
@Controller
@ResponseBody
@RequiredArgsConstructor
public class ImageController {

    private final BoardService boardService;
    private final ImageService imageService;

    /**
     * 이미지를 조회합니다.
     * @param boardId 게시글 Id
     * @return ImageGetResponse
     */
    @GetMapping("/{boardId}")
    public ResponseEntity<ApiResponse<ImageGetResponse>> getImage(
            @PathVariable int boardId
    ){

            ImageGetResponse imageGetResponse = imageService.getImageByBoardId(boardId);
            return ResponseEntity.ok()
                    .body(new ApiResponse<ImageGetResponse>("OK", "Success", imageGetResponse));

    }

    @GetMapping("/{year}/{month}/{memberId}")
    public ImageGetResponseByYearAndMonthAndMember getImageByMember(
            @PathVariable int year,
            @PathVariable int month,
            @PathVariable int memberId
    ){
        try {
            List<String> imagePath = boardService.getImagePaths(year,month,memberId);
            return new ImageGetResponseByYearAndMonthAndMember(imagePath, "OK","Success");
        }catch (Exception e){
            return  new ImageGetResponseByYearAndMonthAndMember(null, "FAIL",e.getMessage());
        }
    }

}
