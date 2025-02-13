package YUN.sobieNote.Member.Repository;

import YUN.sobieNote.Member.Entity.AuthProvider;
import YUN.sobieNote.Member.Entity.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthProviderRepository extends JpaRepository<AuthProvider,Integer> {
    Optional<AuthProvider> findByAuthProvider(String authProvider);

}
