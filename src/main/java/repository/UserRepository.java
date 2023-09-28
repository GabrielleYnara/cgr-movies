package repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmailAddress(String emailAddress);

    boolean existsByEmailAddress(String emailAddress);
}