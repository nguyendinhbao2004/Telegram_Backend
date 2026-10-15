package org.example.telegrambackend.AUTH.auth.dto;

public record LoginRequest(
        String username,
        String password
) {

}
