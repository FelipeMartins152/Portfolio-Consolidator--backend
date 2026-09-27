package com.github.felipemartins152.consolidator.scheduler;

import com.github.felipemartins152.consolidator.repository.BlacklistedTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class BlacklistCleanupScheduler {

    private final BlacklistedTokenRepository blacklistedTokenRepository;

    @Scheduled(cron = "0 0 3 * * *")
    public void cleanExpiredTokens(){
        blacklistedTokenRepository.deleteAllExpiredBefore(Instant.now());
    }

}