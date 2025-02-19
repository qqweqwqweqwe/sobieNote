package YUN.sobieNote.Auth.Controller;


import YUN.sobieNote.Auth.DTO.KakaoGetUserInfoResponse;
import YUN.sobieNote.Auth.Service.KakaoService;
import YUN.sobieNote.Global.DTO.ApiResponse;
import YUN.sobieNote.Member.DTO.MemberLoginRequest;
import YUN.sobieNote.Member.DTO.MemberLoginResponse;
import YUN.sobieNote.Member.Entity.Member;
import YUN.sobieNote.Member.Enum.AUTH_PROVIDER;
import YUN.sobieNote.Member.Enum.MEMBER_ROLE;
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
    public ResponseEntity<ApiResponse<MemberLoginResponse>> callback(
            @RequestParam("code") String code){
        System.out.println(code);

        String token = kakaoService.getAccessTokenFromCode(code);

        KakaoGetUserInfoResponse kakaoGetUserInfoResponse = kakaoService.getUserInfoFromToken(token);

        String name = kakaoGetUserInfoResponse.getKakaoAccount().getProfile().getNickName();
        String email = kakaoGetUserInfoResponse.getKakaoAccount().getEmail();

        MemberLoginRequest memberLoginRequest = new MemberLoginRequest(name, email);
        int authProviderId = AUTH_PROVIDER.KAKAO.getId();
        int memberRoleId = MEMBER_ROLE.USER.getId();
        MemberLoginResponse memberLoginResponse = memberService.findOrSaveMember(memberLoginRequest, authProviderId, memberRoleId);

        return ResponseEntity.ok(new ApiResponse<MemberLoginResponse>("OK","Success", memberLoginResponse));

    }

}
