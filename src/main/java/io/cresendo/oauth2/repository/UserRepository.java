package io.cresendo.oauth2.repository;

import io.cresendo.oauth2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUid(String email);
}
