package wtf.vexel.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wtf.vexel.platform.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // This adds a custom method to find users by their name
    Optional<User> findByUsername(String username);
}