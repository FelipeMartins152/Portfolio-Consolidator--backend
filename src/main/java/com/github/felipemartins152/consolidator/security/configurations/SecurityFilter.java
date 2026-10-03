package com.github.felipemartins152.consolidator.security.configurations;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.felipemartins152.consolidator.domain.User;
import com.github.felipemartins152.consolidator.repository.BlacklistedTokenRepository;
import com.github.felipemartins152.consolidator.repository.UserRepository;
import com.github.felipemartins152.consolidator.security.domain.UserSecurity;
import com.github.felipemartins152.consolidator.security.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    private final UserRepository userRepository;

    private final BlacklistedTokenRepository blacklistedTokenRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        if(token != null){

            var login = tokenService.validateToken(token);

            User user = userRepository.findByEmailAndIsActive(login, true)
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado para o token enviado"));

            UserDetails userDetails = new UserSecurity(user);

            DecodedJWT decodedJWT = tokenService.decode(token);
            String jti = decodedJWT.getId();

            if(blacklistedTokenRepository.existsByJti(jti)){
                filterChain.doFilter(request, response);
                return;
            }

            var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}