package com.github.felipemartins152.consolidator.repository;

import com.github.felipemartins152.consolidator.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndIsActive(String email, boolean b);

    Optional<User> findByUserIdAndIsActive(Long idUser, boolean b);

    boolean existsByEmail(String email);

    boolean existsByEmailAndUserIdNotAndIsActive(String email, Long idUser, boolean b);

    boolean existsByPhoneAndIsActive(String phone, boolean b);

    boolean existsByPhoneAndUserIdNotAndIsActive(String phone, Long idUser, boolean b);
}