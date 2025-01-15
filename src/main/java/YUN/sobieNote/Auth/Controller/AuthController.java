package YUN.sobieNote.Auth.Controller;


import YUN.sobieNote.Auth.DTO.KakaoGetUserInfoResponse;
import YUN.sobieNote.Auth.Service.KakaoService;
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
    public ResponseEntity<?> callback(
            @RequestParam("code") String code){

        System.out.println(code);
        String token = kakaoService.getAccessTokenFromCode(code);
        System.out.println("token : " + token);

        KakaoGetUserInfoResponse kakaoGetUserInfoResponse = kakaoService.getUserInfoFromToken(token);

        System.out.println("user : " + kakaoGetUserInfoResponse);

        System.out.println("email : " + kakaoGetUserInfoResponse.getKakaoAccount().getEmail());
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
