package YUN.sobieNote.Auth.Config;

import YUN.sobieNote.Auth.Filter.JwtAuthenticationFilter;
import YUN.sobieNote.Auth.Service.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.httpBasic(httpBasic -> httpBasic.disable())
                // 브라우저를 통해서 클라이언트와 통신하는게 아니라 rest api를 통해서 통신할 것이므로 토큰 기반 인증을 진행할 것.
                // 그러므로 http basic 인증 (클라이언트가 로그인 방식으로 유저 이름이랑 비밀번호랑 같이 보내는 인증 방식)은 필요 없음.

                .csrf(csrf -> csrf.disable())
                // csrf 보호 비활성화
                // rest api는 stateless하여 사용자의 정보를 저장하지 않음. (csrf 공격은 인증된 사용자의 세션 정보 (주로 세션 쿠키)를 이용하여 진행)
                // csrf 토큰을 요청마다 검증하는 것은 jwt 토큰을 검증하는 것과 중복

                .sessionManagement(sessionManagerment -> sessionManagerment
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                // 토큰 기반 인증이므로 무상태 인증 시스템. (왜냐 요청마다 독립적으로 검증할 것이므로)
                // 즉 세션은 필요가 없다.
                // security context에는 토큰 기반으로 유저 정보 저장
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/member/login").permitAll()
//                        .anyRequest().authenticated()
//                )
                // 로그인 경로를 제외한 모든 경로는 권한이 필요하게끔 설정

//                .exceptionHandling(exceptionalHandling -> exceptionalHandling
//                        .accessDeniedHandler()
//                        .authenticationEntryPoint()
//                ) todo 나중에 custom 응답 제작 지금은 ㄴㄴ // 권한 없는 애들은 이렇게 처리하는 거

                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class ); // 여기다가 Jwtfilter넣어야함
                // 필터 추가, 모든 요청은 저 필터를 먼저 거치게 된다.


        return httpSecurity.build();
    }
}
