package com.github.felipemartins152.consolidator.repository;

import com.github.felipemartins152.consolidator.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}