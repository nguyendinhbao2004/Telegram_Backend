package org.example.telegrambackend.AUTH.user_profiles.mapper;

import org.example.telegrambackend.AUTH.user_profiles.dto.UserProfileResponse;
import org.example.telegrambackend.AUTH.user_profiles.entity.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class UserProfileMapper {
    public UserProfileResponse toResponse(UserProfile profile){
        return new UserProfileResponse(
                profile.getId(),
                profile.getDisplayName(),
                profile.getBio(),
                profile.getAvatarUrl(),
                profile.getDateOfBirth(),
                profile.getCreateAt(),
                profile.getUpdatedAt()
        );
    }
}
