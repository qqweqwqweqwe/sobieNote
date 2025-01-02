package YUN.sobieNote.Member.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class MemberLoginRequest {
    @NotBlank(message = "이름을 입력하세요")
    private String name;


    @NotBlank(message = "이메일을 입력하세요")
    @Email
    private String email;


    public MemberLoginRequest(String name, String email){
        this.email = email;
        this.name = name;
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
