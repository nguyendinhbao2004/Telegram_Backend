package org.example.telegrambackend.AUTH.user_profiles.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.example.telegrambackend.AUTH.user.dto.UserResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record CreateUserProfileRequest(
        @NotBlank(message = "Display name is require")
        @Size(min = 8)
        String displayName,


        @NotBlank(message = "Bio is required")
        String bio,

        String avatarUrl,
        LocalDate birthday
) {
}
