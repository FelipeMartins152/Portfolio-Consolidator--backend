package com.github.felipemartins152.consolidator.service.user;

import com.github.felipemartins152.consolidator.controller.request.user.EditProfileUserRequest;
import com.github.felipemartins152.consolidator.domain.User;
import com.github.felipemartins152.consolidator.repository.UserRepository;
import com.github.felipemartins152.consolidator.service.validator.ValidateUserEmailService;
import com.github.felipemartins152.consolidator.service.validator.ValidateUserPhoneService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class EditProfileUserService {

    private final UserRepository userRepository;

    private final ValidateUserEmailService validateUserEmailService;

    private final ValidateUserPhoneService validateUserPhoneService;


    @Transactional
    public void editProfileUser(Long userId, EditProfileUserRequest request){

        if(request.getEmail() != null){
            validateUserEmailService.validateEmailUniqueEdit(request.getEmail(), userId);
        }

        if(request.getPhone() != null){
            validateUserPhoneService.validatePhoneUniqueEdit(request.getPhone(), userId);
        }

        User user = userRepository.findByUserIdAndIsActive(userId, true)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Usuário não encontrado."));

        updateUser(user, request);

        userRepository.save(user);

    }

    private void updateUser(User user, EditProfileUserRequest request){
        if(request.getFullName() != null)
            user.setFullName(request.getFullName());

        if(request.getEmail() != null)
            user.setEmail(request.getEmail());

        if(request.getPhone() != null)
            user.setPhone(request.getPhone());

        if(request.getBirthDate() != null)
            user.setBirthDate(request.getBirthDate());
    }

}