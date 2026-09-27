package com.github.felipemartins152.consolidator.repository;

import com.github.felipemartins152.consolidator.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUserIdAndIsActive(Long idUser, boolean b);
}