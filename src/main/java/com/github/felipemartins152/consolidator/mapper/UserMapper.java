package com.github.felipemartins152.consolidator.mapper;

import com.github.felipemartins152.consolidator.controller.request.SignUpUserRequest;
import com.github.felipemartins152.consolidator.controller.response.user.SignUpUserResponse;
import com.github.felipemartins152.consolidator.domain.User;

public class UserMapper {

    private UserMapper(){}

    public static User toEntity(SignUpUserRequest signUpUserRequest){
        return User
                .builder()
                .fullName(signUpUserRequest.getFull_name())
                .email(signUpUserRequest.getEmail())
                .password(signUpUserRequest.getPassword())
                .phone(signUpUserRequest.getPhone())
                .birthDate(signUpUserRequest.getBirthDate())
                .build();
    }

    public static SignUpUserResponse toResponse(User user){
        return SignUpUserResponse
                .builder()
                .userId(user.getUserId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .birthDate(user.getBirthDate())
                .build();
    }

}