package com.github.felipemartins152.consolidator.service.user;

import com.github.felipemartins152.consolidator.controller.request.user.ChangePasswordRequest;
import com.github.felipemartins152.consolidator.domain.User;
import com.github.felipemartins152.consolidator.repository.UserRepository;
import com.github.felipemartins152.consolidator.service.validator.ValidateUserCurrentPasswordService;
import com.github.felipemartins152.consolidator.service.validator.ValidateUserNewPasswordService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ChangePasswordUserService {

    private final UserRepository userRepository;

    private final ValidateUserCurrentPasswordService validateUserCurrentPasswordService;

    private final ValidateUserNewPasswordService validateUserNewPasswordService;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void changePasswordUser(Long id, ChangePasswordRequest request){

        User user = userRepository.findByUserIdAndIsActive(id, true)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Usuário não encontrado."));

        validateUserCurrentPasswordService.validateCurrentPassword(user, request.getCurrentPassword());
        validateUserNewPasswordService.validateNewPassword(user, request.getNewPassword());

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        userRepository.save(user);

    }

}