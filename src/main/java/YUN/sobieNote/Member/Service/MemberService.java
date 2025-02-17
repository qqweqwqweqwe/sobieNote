package YUN.sobieNote.Member.Service;

import YUN.sobieNote.Member.DTO.MemberLoginRequest;
import YUN.sobieNote.Member.DTO.MemberLoginResponse;
import YUN.sobieNote.Member.Entity.AuthProvider;
import YUN.sobieNote.Member.Entity.Member;
import YUN.sobieNote.Member.Entity.MemberRole;
import YUN.sobieNote.Member.Repository.AuthProviderRepository;
import YUN.sobieNote.Member.Repository.MemberRepository;
import YUN.sobieNote.Member.Repository.MemberRoleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final AuthProviderRepository authProviderRepository;
    private final MemberRoleRepository memberRoleRepository;


    public Member findMemberByEmail(String email ){
        return memberRepository.findByEmail(email)
                .orElseThrow(()-> new IllegalArgumentException("해당 유저를 찾을 수 없습니다. Email: " + email));
    }


    public MemberLoginResponse findOrSaveMember(MemberLoginRequest memberLoginRequest, int authProviderId, int memberRoleId) {

        try {

            AuthProvider authProvider = authProviderRepository.findById(authProviderId)
                    .orElseThrow(() -> new EntityNotFoundException("해당 소셜 로그인 방식이 없습니다. auth_provider_id: " + authProviderId));

            MemberRole memberRole = memberRoleRepository.findById(memberRoleId)
                    .orElseThrow(() -> new EntityNotFoundException("해당 유저 권한을 찾을 수 없습니다. member_role_id: " + memberRoleId));

            Member member = memberRepository.findByEmail(memberLoginRequest.getEmail())
                    .orElseGet(() -> memberRepository.save(new Member(memberLoginRequest, authProvider, memberRole)));

            return new MemberLoginResponse(member.getId());
        }
        catch (Exception e){
            throw new InternalException("서버 내부 에러가 발생하였습니다 e : " + e.getMessage());
        }
    }


}
