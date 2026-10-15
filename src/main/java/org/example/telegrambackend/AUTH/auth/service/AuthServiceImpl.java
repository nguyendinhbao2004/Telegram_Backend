package org.example.telegrambackend.AUTH.auth.service;

import org.example.telegrambackend.AUTH.auth.dto.LoginRequest;
import org.example.telegrambackend.AUTH.auth.dto.LoginResponse;
import org.example.telegrambackend.AUTH.security.JwtService;
import org.example.telegrambackend.AUTH.user.entity.User;
import org.example.telegrambackend.AUTH.user.repository.UserRepository;
import org.example.telegrambackend.common.exception.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository
                .findByUsername(request.username())
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Invalid username or password")
                );
        if(!passwordEncoder.matches(
                request.password(),
                user.getPassword()
        )){
            throw new ResourceNotFoundException("Invalid username or password");
        }
        String token = jwtService.generateToken(user.getUsername());
        return new LoginResponse(
                token,
                "Bearer"
        );
    }
}
