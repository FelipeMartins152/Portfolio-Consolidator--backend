package com.github.felipemartins152.consolidator.controller.request;

import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Campo Obrigatório")
    private LocalDate birthDate;

}