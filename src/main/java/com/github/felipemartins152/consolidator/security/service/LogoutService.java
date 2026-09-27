package com.github.felipemartins152.consolidator.security.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.felipemartins152.consolidator.domain.BlacklistedToken;
import com.github.felipemartins152.consolidator.repository.BlacklistedTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class LogoutService {

    private final BlacklistedTokenRepository blacklistedTokenRepository;

    private final TokenService tokenService;

    public void logout(String token){

        DecodedJWT decodedJWT = tokenService.decode(token);
        String jti = decodedJWT.getId();
        Instant expiresAt = decodedJWT.getExpiresAt().toInstant();

        blacklistedTokenRepository.save(new BlacklistedToken(jti, expiresAt));

    }

}