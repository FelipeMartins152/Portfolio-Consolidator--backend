package com.github.felipemartins152.consolidator.controller.request.user;

import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;

import static com.github.felipemartins152.consolidator.controller.request.RequestError.EMAIL_FIELD;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class EditProfileUserRequest {

    private String fullName;

    @Email(message = EMAIL_FIELD)
    private String email;

    private String phone;

    private LocalDate birthDate;

}