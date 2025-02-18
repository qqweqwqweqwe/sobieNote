package YUN.sobieNote.Member.Controller;

import YUN.sobieNote.Auth.Service.JwtTokenProvider;
import YUN.sobieNote.Auth.Service.KakaoService;
import YUN.sobieNote.Global.Exception.ErrorResponse;
import YUN.sobieNote.Member.DTO.MemberLoginRequest;
import YUN.sobieNote.Member.DTO.MemberLoginResponse;
import YUN.sobieNote.Member.Repository.MemberRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

    private final JwtTokenProvider jwtTokenProvider;

    @Value("${kakao.redirect_uri}")
    private String KAKAO_LOGIN_REDIRECT_URI;

    @Value("${kakao.rest_api_key}")
    private String KAKAO_REST_API_KEY;


    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(
            @Valid
            @RequestBody MemberLoginRequest memberLoginRequest){
        String name = memberLoginRequest.getName();
        String email = memberLoginRequest.getEmail();

        try{
            long memberId;
            if(name.equals("k0789789") && email.equals("k0789789@naver.com")){ // todo 나중에 db 구축하면 리팩토링
                memberId = 1;
            }else {
                throw new Exception("허걱쓰 ㅋㅋ");
            }

            // todo long memberId = 나중에 데이터베이스에서 가져올 것
            String accessToken = jwtTokenProvider.generateAccessToken(name);
            String refreshToken = jwtTokenProvider.generateRefreshToken(name);

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

    @PostMapping("/login/kakao")
    public ResponseEntity<?> kakaoLogin(HttpServletResponse response) throws IOException {
        String kakaoAuthUrl  ="https://kauth.kakao.com/oauth/authorize?client_id="+ KAKAO_REST_API_KEY + "&redirect_uri=" + KAKAO_LOGIN_REDIRECT_URI;
        response.sendRedirect(kakaoAuthUrl);
        return ResponseEntity.ok().build();

    }


}
