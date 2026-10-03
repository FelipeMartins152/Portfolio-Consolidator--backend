package com.github.felipemartins152.consolidator.service.validator;

import com.github.felipemartins152.consolidator.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
public class ValidateUserNewPasswordService {

    private final PasswordEncoder passwordEncoder;

    public void validateNewPassword(User user, String newPassword){

        if(passwordEncoder.matches(newPassword, user.getPassword()))
            throw new ResponseStatusException(BAD_REQUEST, "A nova senha não pode ser igual a senha atual.");

    }

}