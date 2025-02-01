package YUN.sobieNote.Member.Repository;

import YUN.sobieNote.Member.Entity.AuthProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthProviderRepository extends JpaRepository<AuthProvider,Integer> {
}
