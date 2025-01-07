package YUN.sobieNote.Auth.Service;

import YUN.sobieNote.Auth.DTO.CustomUserDetail;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        
        // 여기서 userName 기반으로 userDetail 찾기
        // 지금은 일단 test용으로  k0789789
        long id = 1;
        String email = "k0789789@naver.com";
        
        UserDetails userDetails = new CustomUserDetail(id,userName,email);
        // todo 예외처리
        return userDetails;
    }


}
