package com.github.felipemartins152.consolidator.controller;

import com.github.felipemartins152.consolidator.controller.request.user.SignUpUserRequest;
import com.github.felipemartins152.consolidator.controller.response.user.SignUpUserResponse;
import com.github.felipemartins152.consolidator.security.domain.UserSecurity;
import com.github.felipemartins152.consolidator.service.DeleteUserService;
import com.github.felipemartins152.consolidator.service.SignUpUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final SignUpUserService signUpUserService;

    private final DeleteUserService deleteUserService;

    @PostMapping
    @ResponseStatus(CREATED)
    public SignUpUserResponse signUpUser (@Valid @RequestBody SignUpUserRequest signUpUserRequest){
        return signUpUserService.signUpUser(signUpUserRequest);
    }

    @DeleteMapping
    @ResponseStatus(OK)
    public void deleteUser(@AuthenticationPrincipal UserSecurity user){
        deleteUserService.removeAccount(user.getId());
    }

}