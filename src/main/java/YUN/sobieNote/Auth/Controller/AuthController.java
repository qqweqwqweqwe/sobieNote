package YUN.sobieNote.Auth.Controller;


import YUN.sobieNote.Auth.DTO.KakaoGetUserInfoResponse;
import YUN.sobieNote.Auth.Service.KakaoService;
import YUN.sobieNote.Member.DTO.MemberLoginRequest;
import YUN.sobieNote.Member.DTO.MemberLoginResponse;
import YUN.sobieNote.Member.Entity.Member;
import YUN.sobieNote.Member.Repository.MemberRepository;
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


    @GetMapping("/kakao/login/callback")
    public ResponseEntity<MemberLoginResponse> callback(
            @RequestParam("code") String code){

        System.out.println(code);
        String token = kakaoService.getAccessTokenFromCode(code);
        System.out.println("token : " + token);

        KakaoGetUserInfoResponse kakaoGetUserInfoResponse = kakaoService.getUserInfoFromToken(token);


        String name = kakaoGetUserInfoResponse.getKakaoAccount().getName();
        String email = kakaoGetUserInfoResponse.getKakaoAccount().getEmail();


        MemberLoginRequest memberLoginRequest = new MemberLoginRequest(name,email);
        long id;
        Member member;
        if(!kakaoService.isRegistered(email)){  // 회원가입 안했으면
            member = kakaoService.saveMember(memberLoginRequest);
            id = member.getId();
        }else{
            member = kakaoService.findByEmail(email);
            id = member.getId();
        }
        return ResponseEntity.ok()
                .body(new MemberLoginResponse(id));

    }

}
