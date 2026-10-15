package org.example.telegrambackend.AUTH.user_profiles.dto;

import java.time.LocalDate;

public record UpdateUserProfileRequest(
        String displayName,
        String bio,
        String avatarUrl,
        LocalDate birthday
) {
}
