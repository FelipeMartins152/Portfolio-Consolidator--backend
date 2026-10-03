package com.github.felipemartins152.consolidator.service.user;

import com.github.felipemartins152.consolidator.controller.request.user.SignUpUserRequest;
import com.github.felipemartins152.consolidator.controller.response.user.SignUpUserResponse;
import com.github.felipemartins152.consolidator.domain.User;
import com.github.felipemartins152.consolidator.repository.UserRepository;
import com.github.felipemartins152.consolidator.service.validator.ValidateUserEmailService;
import com.github.felipemartins152.consolidator.service.validator.ValidateUserPhoneService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.github.felipemartins152.consolidator.mapper.UserMapper.toEntity;
import static com.github.felipemartins152.consolidator.mapper.UserMapper.toResponse;

@Service
@RequiredArgsConstructor
public class SignUpUserService {

    private final UserRepository userRepository;

    private final ValidateUserEmailService validateUserEmailService;

    private final ValidateUserPhoneService validateUserPhoneService;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignUpUserResponse signUpUser (SignUpUserRequest signUpUserRequest){

        validateUserEmailService.validateEmailUnique(signUpUserRequest.getEmail());
        validateUserPhoneService.validatePhoneUnique(signUpUserRequest.getPhone());

        User user = toEntity(signUpUserRequest);

        user.setActive(true);
        user.setPassword(passwordEncoder.encode(signUpUserRequest.getPassword()));

        userRepository.save(user);

        return toResponse(user);
    }

}