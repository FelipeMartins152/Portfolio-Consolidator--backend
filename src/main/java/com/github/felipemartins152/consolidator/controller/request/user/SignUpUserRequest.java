package com.github.felipemartins152.consolidator.controller.request.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class SignUpUserRequest {

    @NotBlank(message = "Campo Obrigatório")
    private String fullName;

    @NotBlank(message = "Campo Obrigatório")
    private String email;

    @NotBlank(message = "Campo Obrigatório")
    private String phone;

    @NotBlank(message = "Campo Obrigatório")
    private String password;

    @NotNull(message = "Campo Obrigatório")
    private LocalDate birthDate;

}