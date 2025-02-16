package YUN.sobieNote.Auth.Controller;


import YUN.sobieNote.Auth.DTO.KakaoGetUserInfoResponse;
import YUN.sobieNote.Auth.Service.KakaoService;
import YUN.sobieNote.Member.DTO.MemberLoginRequest;
import YUN.sobieNote.Member.DTO.MemberLoginResponse;
import YUN.sobieNote.Member.Entity.Member;
import YUN.sobieNote.Member.Exception.MemberLoginErrorResponse;
import YUN.sobieNote.Member.Repository.MemberRepository;
import YUN.sobieNote.Member.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final KakaoService kakaoService;
    private final MemberService memberService;


    @GetMapping("/kakao/login/callback")
    public ResponseEntity<?> callback(
            @RequestParam("code") String code){
        System.out.println(code);

        try {
            String token = kakaoService.getAccessTokenFromCode(code);

            KakaoGetUserInfoResponse kakaoGetUserInfoResponse = kakaoService.getUserInfoFromToken(token);

            String name = kakaoGetUserInfoResponse.getKakaoAccount().getProfile().getNickName();
            String email = kakaoGetUserInfoResponse.getKakaoAccount().getEmail();
            MemberLoginRequest memberLoginRequest = new MemberLoginRequest(name, email);
            int authProviderId = 1;   // 카카오
            int memberRoleId = 1;     // 일반 유저
            Member member = memberService.findOrSaveMember(memberLoginRequest, authProviderId, memberRoleId);

            return ResponseEntity.ok()
                    .body(new MemberLoginResponse(member.getId()));

        }
        catch (Exception e){
            return ResponseEntity.badRequest()
                    .body(new MemberLoginErrorResponse(e.getClass().getSimpleName(), e.getMessage()));
        }
    }

}
