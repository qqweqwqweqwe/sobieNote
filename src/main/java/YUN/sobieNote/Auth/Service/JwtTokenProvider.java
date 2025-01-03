package YUN.sobieNote.Auth.Service;

import YUN.sobieNote.Config.DotenvConfig;
import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Service
public class JwtTokenProvider {

    private final Dotenv dotenv;
    private final int accessTokenExpirationTime;
    private final int refreshTokenExpirationTime;
    private final String JWT_SECRET_KEY;

    public JwtTokenProvider(){
        dotenv = DotenvConfig.getInstance();
        accessTokenExpirationTime = 3600;
        refreshTokenExpirationTime = 99999999; //todo 적당한 걸로 바꾸기
        JWT_SECRET_KEY = dotenv.get("JWT_SECRET_KEY");

    }

    public String generareToken(long memeberid){

        memeberid = 1; // 테스트용
        Key key = new SecretKeySpec(JWT_SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());

        return Jwts.builder()
                .setSubject(String.valueOf(memeberid))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpirationTime))
                .signWith(key)
                .compact();


    }
}
