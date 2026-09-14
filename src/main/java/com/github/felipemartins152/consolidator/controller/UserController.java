package com.github.felipemartins152.consolidator.controller;

import com.github.felipemartins152.consolidator.controller.request.SignUpUserRequest;
import com.github.felipemartins152.consolidator.controller.response.user.SignUpUserResponse;
import com.github.felipemartins152.consolidator.service.SignUpUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final SignUpUserService signUpUserService;


    @PostMapping
    @ResponseStatus(CREATED)
    public SignUpUserResponse signUpUser (@Valid @RequestBody SignUpUserRequest signUpUserRequest){
        return signUpUserService.signUpUser(signUpUserRequest);
    }

}