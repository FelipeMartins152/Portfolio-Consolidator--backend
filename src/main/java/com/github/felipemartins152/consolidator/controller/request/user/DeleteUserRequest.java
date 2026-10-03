package com.github.felipemartins152.consolidator.controller.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import static com.github.felipemartins152.consolidator.controller.request.RequestError.REQUIRED_FIELD;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class DeleteUserRequest {

    @NotBlank(message = REQUIRED_FIELD)
    private String token;

}