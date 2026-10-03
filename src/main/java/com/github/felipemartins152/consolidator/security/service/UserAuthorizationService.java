package com.github.felipemartins152.consolidator.security.service;

import com.github.felipemartins152.consolidator.domain.User;
import com.github.felipemartins152.consolidator.repository.UserRepository;
import com.github.felipemartins152.consolidator.security.domain.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthorizationService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmailAndIsActive(username, true)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
        return new UserSecurity(user);
    }
}