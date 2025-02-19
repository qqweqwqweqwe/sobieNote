package YUN.sobieNote.Auth.Service;

import YUN.sobieNote.Auth.DTO.KakaoGetTokenResponse;
import YUN.sobieNote.Auth.DTO.KakaoGetUserInfoResponse;
import YUN.sobieNote.Global.Exception.CustomException;
import YUN.sobieNote.Member.DTO.MemberLoginRequest;
import YUN.sobieNote.Member.Entity.Member;
import YUN.sobieNote.Member.Repository.MemberRepository;
import io.netty.handler.codec.http.HttpHeaderValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class KakaoService {


    private final String REST_API_KEY;
    private final String REDIRECT_URI;

    @Autowired
    private MemberRepository memberRepository;

    public KakaoService(
            @Value("${kakao.rest_api_key}") String REST_API_KEY,
            @Value("${kakao.redirect_uri}") String REDIRECT_URI) {
        this.REST_API_KEY = REST_API_KEY;
        this.REDIRECT_URI = REDIRECT_URI;
    }


    /**
     * 카카오로부터 코드를 통해 토큰을 가져옵니다.
     * @param code
     * @return
     */
    public String getAccessTokenFromCode(String code) {

        String token = "";
        try {
            KakaoGetTokenResponse kakaoGetTokenResponse = WebClient.create("https://kauth.kakao.com/oauth/token")
                    .post()
                    .uri(uriBuilder -> uriBuilder
                            .queryParam("grant_type", "authorization_code")
                            .queryParam("client_id", REST_API_KEY)
                            .queryParam("redirect_uri", REDIRECT_URI)
                            .queryParam("code", code)
                            .build()
                    ).header(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED.toString())
                    .retrieve()   // 전송
                    .bodyToMono(KakaoGetTokenResponse.class) // 응답값을 매핑해주는 것 같은데?
                    .block();   // await
            token = kakaoGetTokenResponse.getAccessToken();
            return token;

        }catch (Exception e){
            throw new CustomException.ExternalAPIException("카카오 인증 코드로 부터 토큰을 가져오는 것을 실패하였습니다" + e.getMessage());
        }

    }

    /**
     * 카카오로부터 유저 정보를 가져옵니다.
     * @param token
     * @return
     */
    public KakaoGetUserInfoResponse getUserInfoFromToken(String token){

        KakaoGetUserInfoResponse kakaoGetUserInfoResponse = WebClient.create("https://kapi.kakao.com/v2/user/me")
                .get()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .header(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED.toString())
                .retrieve()   // 전송
                .bodyToMono(KakaoGetUserInfoResponse.class) // 응답값을 매핑해주는 것 같은데?
                .block();   // await

        return kakaoGetUserInfoResponse;
    }

}
