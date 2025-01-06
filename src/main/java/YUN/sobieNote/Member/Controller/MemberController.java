package YUN.sobieNote.Member.Controller;

import YUN.sobieNote.Auth.Service.AuthService;
import YUN.sobieNote.Global.Exception.ErrorResponse;
import YUN.sobieNote.Member.DTO.MemberLoginRequest;
import YUN.sobieNote.Member.DTO.MemberLoginResponse;
import YUN.sobieNote.Member.Exception.NotValidatedValueException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private final AuthService authService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(
            @Valid
            @RequestBody MemberLoginRequest memberLoginRequest){
        String name = memberLoginRequest.getName();
        String email = memberLoginRequest.getEmail();

        try{
            long memberId = 1; //  테스트용 임의의 멤버 Id입니다.
            // todo long memberId = 나중에 데이터베이스에서 가져올 것
            String accessToken = authService.generateAccessToken(memberId);
            String refreshToken = authService.generateRefreshToken(memberId);
            return ResponseEntity.ok()
                    .header("Authorization", "Bearer "+ accessToken)
                    .header("Refresh-Token",refreshToken)
                    .body(new MemberLoginResponse(memberId));
        }  catch (Exception e){

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("INTERNAL_SERVER_ERROR", "예상치 못한 에러가 발생하였습니다"));
        }
    }
}
