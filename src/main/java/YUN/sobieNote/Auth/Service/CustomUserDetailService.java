package YUN.sobieNote.Auth.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        if(memberId.equals("1")){

        }
        // 여기서 커스텀 디테일 서비스

        return null;
    }

}
