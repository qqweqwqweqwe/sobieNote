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

        if (authorization != null && authorization.startsWith("Bearer ")) { // Bearer 토큰 파싱
            token = authorization.substring(7); // jwt token 파싱
            userName = jwtTokenProvider.getUserNameFromToken(token);
        } else {
            filterChain.doFilter(request, response); // 이거 뭔지 검색 ㄱ
        }

        if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null){ //SecurityContextHolder.getContext().getAuthentication() 통해서 반환되는 객체는 토큰을 통해서 실행
            // 여기서 예외처리 들어가줘야함

            UserDetails userDetails = userDetailService.loadUserByUsername(userName);
            // 이것도 통과하면
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        }

        filterChain.doFilter(request,response);


    }
}
