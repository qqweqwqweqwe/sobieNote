package YUN.sobieNote.Auth.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.httpBasic(httpBasic -> httpBasic.disable())
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sessionManagerment -> sessionManagerment
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/member/login").permitAll()
                        .anyRequest().denyAll()
                )
//                .exceptionHandling(exceptionalHandling -> exceptionalHandling
//                        .accessDeniedHandler()
//                        .authenticationEntryPoint()
//                ) todo 나중에 custom 응답 제작 지금은 ㄴㄴ
                .addFilterBefore();

        return httpSecurity.build();
    }
}
