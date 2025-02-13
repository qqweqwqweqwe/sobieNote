package YUN.sobieNote.Member.Seeder;


import YUN.sobieNote.Auth.Controller.AuthController;
import YUN.sobieNote.Board.Entity.Category;
import YUN.sobieNote.Member.Entity.AuthProvider;
import YUN.sobieNote.Member.Entity.Member;
import YUN.sobieNote.Member.Entity.MemberRole;
import YUN.sobieNote.Member.Repository.AuthProviderRepository;
import YUN.sobieNote.Member.Repository.MemberRepository;
import YUN.sobieNote.Member.Repository.MemberRoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberSeeder {
    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final AuthProviderRepository authProviderRepository;


    @PostConstruct
    @Transactional
    public void initMembers() {


        try {
            MemberRole memberRole = memberRoleRepository.save(MemberRole.builder()
                    .role("USER")
                    .build());

            AuthProvider authProvider = authProviderRepository.save(AuthProvider.builder()
                    .authProvider("KAKAO")
                    .build()
            );

            Member member = Member.builder()
                    .id(0)
                    .name("테스트")
                    .email("test@test.com")
                    .memberRole(memberRole)
                    .authProvider(authProvider)
                    .build();

            memberRepository.save(member);
        }
        catch (Exception e){
            // 어쩔수 없다 일단 이렇게 ㄱ
        }

    }

}
