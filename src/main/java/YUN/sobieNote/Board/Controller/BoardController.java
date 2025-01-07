package YUN.sobieNote.Board.Controller;


import YUN.sobieNote.Board.DTO.BoardRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {

    @PostMapping("/posting/{memberId}")
    @ResponseBody
    public void createPost(
            @PathVariable Long memberId,
            @RequestBody BoardRequest request
            ){
        


    }
}
