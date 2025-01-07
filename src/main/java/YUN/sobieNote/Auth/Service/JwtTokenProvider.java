package YUN.sobieNote.Auth.Service;

import YUN.sobieNote.Config.DotenvConfig;
import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.*;
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
    private final int ACCESS_TOKEN_EXPIRATION_TIME;
    private final int REFRESH_TOKEN_EXPIRATION_TIME;
    private final String JWT_SECRET_KEY;

    public JwtTokenProvider(){
        dotenv = DotenvConfig.getInstance();
        ACCESS_TOKEN_EXPIRATION_TIME = 3600;
        REFRESH_TOKEN_EXPIRATION_TIME = 99999999; //todo 적당한 걸로 바꾸기
        JWT_SECRET_KEY = dotenv.get("JWT_SECRET_KEY");

    }

    public String generateAccessToken(String userName){
        userName = "k0789789"; // 테스트용
        Key key = new SecretKeySpec(JWT_SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        Claims claims = Jwts.claims();
        claims.put("userName", userName);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION_TIME))
                .signWith(key)
                .compact();

    }

    public String generateRefreshToken(String userName){
        userName = "k0789789"; // 테스트용
        Key key = new SecretKeySpec(JWT_SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        Claims claims = Jwts.claims();
        claims.put("userName", userName);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRATION_TIME))
                .signWith(key)
                .compact();

    }

    public boolean isValidToken(String token){
        Key key = new SecretKeySpec(JWT_SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            Date expiration = claims.getExpiration();
            // 토큰이 만료 되었으면
            if (expiration.before(new Date())) {
                throw new ExpiredJwtException(null, claims, "토큰이 만료되었습니다");
            }
            return true;

        }catch (Exception e){
            // todo 로그 쌓기
            return false;
        }
    }

    public String getUserNameFromToken(String token){

        Key key = new SecretKeySpec(JWT_SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        String userName = (String) claims.get("userName"); // userName이 없으면 해당 토큰은 유효하지 않은 토큰이다.


        return userName;
    }

}
