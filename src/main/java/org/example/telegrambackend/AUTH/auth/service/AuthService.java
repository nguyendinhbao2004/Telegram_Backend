package org.example.telegrambackend.AUTH.auth.service;

import org.example.telegrambackend.AUTH.auth.dto.LoginRequest;
import org.example.telegrambackend.AUTH.auth.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}
