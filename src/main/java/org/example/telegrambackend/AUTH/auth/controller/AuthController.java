package org.example.telegrambackend.AUTH.auth.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.telegrambackend.AUTH.auth.dto.LoginRequest;
import org.example.telegrambackend.AUTH.auth.dto.LoginResponse;
import org.example.telegrambackend.AUTH.auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@Tag(
        name = "Auth",
        description = "Authentication"
)
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request
    ){
        return ResponseEntity.ok(
                authService.login(request)
        );
    }
}
