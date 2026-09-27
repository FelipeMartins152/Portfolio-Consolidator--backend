package com.github.felipemartins152.consolidator.security.controller;

import com.github.felipemartins152.consolidator.security.domain.AuthenticationDTO;
import com.github.felipemartins152.consolidator.security.domain.LoginResponseDTO;
import com.github.felipemartins152.consolidator.security.service.LogoutService;
import com.github.felipemartins152.consolidator.security.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    private final LogoutService logoutService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserDetails) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        String token = authHeader.replace("Bearer ", "");
        logoutService.logout(token);
        return ResponseEntity.noContent().build();
    }
}