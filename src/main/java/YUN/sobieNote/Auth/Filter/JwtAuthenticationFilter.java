package YUN.sobieNote.Auth.Filter;

import YUN.sobieNote.Auth.Service.CustomUserDetailService;
import YUN.sobieNote.Auth.Service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final CustomUserDetailService userDetailService;
    private final JwtService jwtTokenProvider;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            System.out.println("🔍 Request Class: " + request.getClass().getName());
            System.out.println("🔍 Authorization 헤더: " + request.getHeader("Authorization"));
            System.out.println("🔍 모든 헤더: ");

            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                System.out.println("    " + headerName + " : " + request.getHeader(headerName));
            }

            String authorization = request.getHeader("authorization");
            System.out.println(authorization);
            int memberId;
            String memberRole;
            String token;
            HttpServletRequestWrapper wrappedRequest = new HttpServletRequestWrapper(request);
            String authorizationHeader = wrappedRequest.getHeader("authorization");
            System.out.println(authorizationHeader);
            // 토큰 파싱
            if (authorization != null && authorization.startsWith("Bearer ")) { // Bearer 토큰 파싱
                token = authorization.substring(7); // jwt token 파싱
            } else {
                throw new IllegalArgumentException("토큰이 없습니다");
            }

            // memberId 파싱
            memberId = jwtTokenProvider.getMemberIdFromToken(token);
            memberRole = jwtTokenProvider.getMemberRoleFromToken(token);
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(memberRole);

            System.out.println(memberId);
            System.out.println(memberRole);

            // 이미 인증 정보가 있는 경우
            if (SecurityContextHolder.getContext().getAuthentication() != null) {
                return;
            }

            UserDetails userDetails = new User(String.valueOf(memberId), "", Collections.singleton(authority));

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            filterChain.doFilter(request, response);

        }
        catch (Exception e){
            // todo 여기서 에러 처리 다 세부적으로 나눠줘야함
            //
            throw e;
        }


    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String uri = request.getRequestURI();
//        return uri.startsWith("/member/login");
        return true;
    }
}
