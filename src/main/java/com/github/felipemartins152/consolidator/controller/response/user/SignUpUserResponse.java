package com.github.felipemartins152.consolidator.controller.response.user;

import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class SignUpUserResponse {

    private Long userId;

    private String fullName;

    private String email;

    private String phone;

    private LocalDate birthDate;

}