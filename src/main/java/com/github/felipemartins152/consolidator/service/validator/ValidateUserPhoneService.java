package com.github.felipemartins152.consolidator.service.validator;

import com.github.felipemartins152.consolidator.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.CONFLICT;

@Service
@RequiredArgsConstructor
public class ValidateUserPhoneService {

    private final UserRepository userRepository;

    public void validatePhoneUnique(String phone){

        if(userRepository.existsByPhoneAndIsActive(phone, true))
            throw new ResponseStatusException(CONFLICT, "Esse telefone já foi cadastrado.");

    }

    public void validatePhoneUniqueEdit(String phone, Long idUser){

        if(userRepository.existsByPhoneAndUserIdNotAndIsActive(phone, idUser, true))
            throw new ResponseStatusException(CONFLICT, "Esse telefone já foi cadastrado.");

    }

}