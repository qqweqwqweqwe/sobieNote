package YUN.sobieNote.Member;


import YUN.sobieNote.Member.Entity.AuthProvider;
import YUN.sobieNote.Member.Entity.Member;
import YUN.sobieNote.Member.Entity.MemberRole;
import YUN.sobieNote.Member.Repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원 저장 테스트 : 기본 로그인")
    void saveTest(){
        AuthProvider authProvider = AuthProvider.builder()
                .authProvider("KAKAO")
                .build();
        MemberRole memberRole = MemberRole.builder()
                .role("USER")
                .build();
        Member member = Member.builder()
                .name("연준")
                .email("test@naver.com")
                .authProvider(authProvider)
                .memberRole(memberRole)
                .build();
        Member savedMember = memberRepository.save(member);

        assertEquals("연준", savedMember.getName());
        assertEquals("test@naver.com", savedMember.getEmail());

    }
}
