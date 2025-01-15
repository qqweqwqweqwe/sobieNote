package YUN.sobieNote.Auth.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class KakaoGetTokenResponse {

    private String token_type;

    private String access_token;

    private String id_token;

    private int expires_in;

    private String refresh_token;

    private int refresh_token_expires_in;

    private String scope;


}
