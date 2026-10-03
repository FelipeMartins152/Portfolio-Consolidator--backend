package com.github.felipemartins152.consolidator.service.validator;

import com.github.felipemartins152.consolidator.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
public class ValidateUserCurrentPasswordService {

    private final PasswordEncoder passwordEncoder;

    public void validateCurrentPassword(User user, String currentPassword){

        if(!passwordEncoder.matches(currentPassword, user.getPassword()))
            throw new ResponseStatusException(BAD_REQUEST, "Senha atual incorreta.");

    }

}