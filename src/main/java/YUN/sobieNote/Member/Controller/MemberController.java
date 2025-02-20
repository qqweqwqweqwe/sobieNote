package YUN.sobieNote.Member.Controller;

import YUN.sobieNote.Auth.DTO.KakaoGetUserInfoResponse;
import YUN.sobieNote.Auth.Service.JwtService;
import YUN.sobieNote.Auth.Service.KakaoService;
import YUN.sobieNote.Global.DTO.ApiResponse;
import YUN.sobieNote.Global.Exception.ErrorResponse;
import YUN.sobieNote.Member.DTO.MemberLoginRequest;
import YUN.sobieNote.Member.DTO.MemberLoginResponse;
import YUN.sobieNote.Member.Enum.AUTH_PROVIDER;
import YUN.sobieNote.Member.Enum.MEMBER_ROLE;
import YUN.sobieNote.Member.Service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

    private final JwtService jwtService;
    private final KakaoService kakaoService;
    private final MemberService memberService;

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
            int memberId;
            if(name.equals("k0789789") && email.equals("k0789789@naver.com")){ // todo 나중에 db 구축하면 리팩토링
                memberId = 1;
            }else {
                throw new Exception("허걱쓰 ㅋㅋ");
            }

            // todo long memberId = 나중에 데이터베이스에서 가져올 것
            String accessToken = jwtService.generateAccessToken(memberId);
            String refreshToken = jwtService.generateRefreshToken(name);

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
        String kakaoAuthUrl  ="https://kauth.kakao.com/oauth/authorize?client_id="+ KAKAO_REST_API_KEY + "&redirect_uri=" + KAKAO_LOGIN_REDIRECT_URI + "&response_type=code";
        response.sendRedirect(kakaoAuthUrl);
        return ResponseEntity.ok().build();

    }


    @GetMapping("/login/kakao/callback")
    public ResponseEntity<ApiResponse<MemberLoginResponse>> kakaoLoginCallback(
            @RequestParam("code") String code,
            HttpServletResponse response
            ){
        String token = kakaoService.getAccessTokenFromCode(code);

        KakaoGetUserInfoResponse kakaoGetUserInfoResponse = kakaoService.getUserInfoFromToken(token);

        String name = kakaoGetUserInfoResponse.getKakaoAccount().getProfile().getNickName();
        String email = kakaoGetUserInfoResponse.getKakaoAccount().getEmail();

        MemberLoginRequest memberLoginRequest = new MemberLoginRequest(name, email);
        int authProviderId = AUTH_PROVIDER.KAKAO.getId();
        int memberRoleId = MEMBER_ROLE.USER.getId();

        MemberLoginResponse memberLoginResponse = memberService.findOrSaveMember(memberLoginRequest, authProviderId, memberRoleId);
        String accessToken = jwtService.generateAccessToken(memberLoginResponse.getMemberId());
        response.setHeader("Authorization", "Bearer " + accessToken);

        return ResponseEntity.ok(new ApiResponse<MemberLoginResponse>("OK","Success", memberLoginResponse));

    }



}
