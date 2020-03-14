package rclub.wss.persistance.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import rclub.wss.domain.auth.User;

import java.util.Optional;

public interface UserRep extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
