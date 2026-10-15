package org.example.telegrambackend.AUTH.user_profiles.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserProfileResponse(
        Long id,
        String displayName,
        String bio,
        String avatarUrl,
        LocalDate dateOfBirth,
        LocalDateTime createAt,
        LocalDateTime updateAt
) {
}
