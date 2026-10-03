package com.github.felipemartins152.consolidator.controller.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

import static com.github.felipemartins152.consolidator.controller.request.RequestError.*;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class SignUpUserRequest {

    @NotBlank(message = REQUIRED_FIELD)
    private String fullName;
    
    @Email(message = EMAIL_FIELD)
    private String email;

    @NotBlank(message = REQUIRED_FIELD)
    private String phone;

    @NotBlank(message = REQUIRED_FIELD)
    private String password;

    @NotNull(message = REQUIRED_FIELD)
    private LocalDate birthDate;

}