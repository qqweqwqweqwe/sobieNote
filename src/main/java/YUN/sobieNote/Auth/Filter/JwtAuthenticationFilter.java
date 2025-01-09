package YUN.sobieNote.Auth.Filter;

import YUN.sobieNote.Auth.Service.CustomUserDetailService;
import YUN.sobieNote.Auth.Service.JwtTokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final CustomUserDetailService userDetailService;
    private final JwtTokenProvider jwtTokenProvider;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        String userName = "";
        String token = "";
        try {
            // 토큰 파싱
            if (authorization != null && authorization.startsWith("Bearer ")) { // Bearer 토큰 파싱
                token = authorization.substring(7); // jwt token 파싱
            } else {
                throw new Exception("토큰이 없습니다");
            }

            // userName 파싱
            if (jwtTokenProvider.isValidToken(token)) {
                userName = jwtTokenProvider.getUserNameFromToken(token);
            } else {
                throw new Exception("토큰이 유효하지 않습니다");
            }

            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) { //SecurityContextHolder.getContext().getAuthentication() 통해서 반환되는 객체는 토큰을 통해서 실행

                UserDetails userDetails = userDetailService.loadUserByUsername(userName);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        filterChain.doFilter(request, response);


    }
}
