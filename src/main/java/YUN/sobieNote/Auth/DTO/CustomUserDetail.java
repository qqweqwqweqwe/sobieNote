package YUN.sobieNote.Auth.DTO;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetail implements UserDetails {

    private long id;	// DB에서 PK 값
    private String userName;		// 로그인용 ID 값
    private String email;	//이메일
    private Collection<GrantedAuthority> authorities;	//권한 목록

    public CustomUserDetail(long id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return this.userName;
    }
}
