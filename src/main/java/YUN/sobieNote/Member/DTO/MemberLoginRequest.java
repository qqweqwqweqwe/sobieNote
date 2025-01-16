package YUN.sobieNote.Member.DTO;

import YUN.sobieNote.Member.Entity.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class MemberLoginRequest {

    private String name;


    @NotBlank(message = "이메일을 입력하세요")
    @Email
    private String email;


    public MemberLoginRequest(String name, String email){
        this.email = email;
        this.name = name;
    }

    public Member toEntity(){
        return Member.builder()
                .name(this.name)
                .email(this.email)
                .build();
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}
