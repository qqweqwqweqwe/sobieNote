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
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sessionManagerment -> sessionManagerment
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/member/login").permitAll()
                        .anyRequest().authenticated()
                )
//                .exceptionHandling(exceptionalHandling -> exceptionalHandling
//                        .accessDeniedHandler()
//                        .authenticationEntryPoint()
//                ) todo 나중에 custom 응답 제작 지금은 ㄴㄴ // 권한 없는 애들은 이렇게 처리하는 거
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class ); // 여기다가 Jwtfilter넣어야함


        return httpSecurity.build();
    }
}
