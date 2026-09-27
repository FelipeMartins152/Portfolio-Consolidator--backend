package com.github.felipemartins152.consolidator.controller.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import static com.github.felipemartins152.consolidator.controller.request.RequestError.CAMPO_OBRIGATORIO;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class DeleteUserRequest {

    @NotBlank(message = CAMPO_OBRIGATORIO)
    private String token;

}