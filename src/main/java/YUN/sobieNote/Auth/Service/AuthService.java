package YUN.sobieNote.Auth.Service;

import YUN.sobieNote.Config.DotenvConfig;
import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

@Service
public class AuthService {

    private final String JWT_SECRET_KEY;

    public AuthService(){
        Dotenv dotenv = DotenvConfig.getInstance();
        JWT_SECRET_KEY = dotenv.get("JWT_SECRET_KEY");
    }

    public String generateAccessToken(long memberId) {
        Key key = new SecretKeySpec(JWT_SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        return Jwts.builder()
                .setSubject(String.valueOf(memberId))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600))
                .signWith(key)
                .compact();

    }

    public String generateRefreshToken(long memberId){
        Key key = new SecretKeySpec(JWT_SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        return Jwts.builder()
                .setSubject(String.valueOf(memberId))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600))
                .signWith(key)
                .compact();
    }
}
