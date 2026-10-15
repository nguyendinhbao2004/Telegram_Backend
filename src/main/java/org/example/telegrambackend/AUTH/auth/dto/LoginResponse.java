package org.example.telegrambackend.AUTH.auth.dto;

public record LoginResponse(
        String accessToken,
        String tokenType
) {
}
