package com.github.felipemartins152.consolidator.repository;


import com.github.felipemartins152.consolidator.domain.BlacklistedToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;

public interface BlacklistedTokenRepository extends JpaRepository<BlacklistedToken, String> {

    boolean existsByJti(String jti);

    @Modifying
    @Query("DELETE FROM BlacklistedToken b WHERE b.expiresAt < :now")
    void deleteAllExpiredBefore(Instant now);

}