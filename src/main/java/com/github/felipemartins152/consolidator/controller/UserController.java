package com.github.felipemartins152.consolidator.controller;

import com.github.felipemartins152.consolidator.controller.request.user.EditProfileUserRequest;
import com.github.felipemartins152.consolidator.controller.request.user.SignUpUserRequest;
import com.github.felipemartins152.consolidator.controller.response.user.SignUpUserResponse;
import com.github.felipemartins152.consolidator.security.domain.UserSecurity;
import com.github.felipemartins152.consolidator.service.user.DeleteUserService;
import com.github.felipemartins152.consolidator.service.user.EditProfileUserService;
import com.github.felipemartins152.consolidator.service.user.SignUpUserService;
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

    private final EditProfileUserService editProfileUserService;

    @PostMapping
    @ResponseStatus(CREATED)
    public SignUpUserResponse signUpUser (@Valid @RequestBody SignUpUserRequest signUpUserRequest){
        return signUpUserService.signUpUser(signUpUserRequest);
    }

    @PutMapping("/edit-profile")
    @ResponseStatus(OK)
    public void editProfileUser(@AuthenticationPrincipal UserSecurity user,
                                @Valid @RequestBody EditProfileUserRequest request){
        editProfileUserService.editProfileUser(user.getId(), request);
    }

    @DeleteMapping
    @ResponseStatus(OK)
    public void deleteUser(@AuthenticationPrincipal UserSecurity user){
        deleteUserService.removeAccount(user.getId());
    }

}