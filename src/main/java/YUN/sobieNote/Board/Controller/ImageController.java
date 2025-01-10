package YUN.sobieNote.Board.Controller;


import YUN.sobieNote.Board.DTO.ImageGetResponse;
import YUN.sobieNote.Board.DTO.ImageGetResponseByMember;
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
public class ImageController {

    /**
     * 이미지를 조회합니다.
     * @param boardId 게시글 Id
     * @return ImageGetResponse
     */
    @GetMapping("/{boardId}")
    public ResponseEntity<ImageGetResponse> getImage(
            @PathVariable long boardId
    ){
        ImageGetResponse.Data data= new ImageGetResponse.Data(
                "test",
                new Date(),
                "test",
                "test",
                1,
                "test"
        );
        ImageGetResponse imageGetResponse = new ImageGetResponse(
                "test",
                "test",
                data
        );
        return ResponseEntity.ok()
                .body(imageGetResponse);

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
