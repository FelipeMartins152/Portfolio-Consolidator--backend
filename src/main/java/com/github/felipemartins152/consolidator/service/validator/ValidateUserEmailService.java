package com.github.felipemartins152.consolidator.service.validator;

import com.github.felipemartins152.consolidator.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.CONFLICT;

@Service
@RequiredArgsConstructor
public class ValidateUserEmailService {

    private final UserRepository userRepository;

    public void validateEmailUnique(String email){

        if(userRepository.existsByEmailAndIsActive(email, true))
            throw new ResponseStatusException(CONFLICT, "Esse email já foi cadastrado.");

    }

    public void validateEmailUniqueEdit(String email, Long idUser){

        if(userRepository.existsByEmailAndUserIdNotAndIsActive(email, idUser, true))
            throw new ResponseStatusException(CONFLICT, "Esse email já foi cadastrado.");

    }

}