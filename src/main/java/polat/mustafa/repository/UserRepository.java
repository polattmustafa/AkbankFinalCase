package polat.mustafa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import polat.mustafa.model.User;

/**
 * @author MPolat
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
