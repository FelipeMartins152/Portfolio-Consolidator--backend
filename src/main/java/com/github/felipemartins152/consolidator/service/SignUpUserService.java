package com.github.felipemartins152.consolidator.service;

import com.github.felipemartins152.consolidator.controller.request.SignUpUserRequest;
import com.github.felipemartins152.consolidator.controller.response.user.SignUpUserResponse;
import com.github.felipemartins152.consolidator.domain.User;
import com.github.felipemartins152.consolidator.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.github.felipemartins152.consolidator.mapper.UserMapper.toEntity;
import static com.github.felipemartins152.consolidator.mapper.UserMapper.toResponse;

@Service
@RequiredArgsConstructor
public class SignUpUserService {

    private final UserRepository userRepository;

    @Transactional
    public SignUpUserResponse signUpUser (SignUpUserRequest signUpUserRequest){
        User user = toEntity(signUpUserRequest);

        user.setActive(true);
        user.setPassword(signUpUserRequest.getPassword());

        userRepository.save(user);

        return toResponse(user);
    }

}