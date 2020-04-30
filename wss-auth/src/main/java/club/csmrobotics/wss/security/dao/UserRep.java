package club.csmrobotics.wss.security.dao;

import club.csmrobotics.wss.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRep extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
