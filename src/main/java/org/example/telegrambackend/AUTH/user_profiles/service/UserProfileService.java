package org.example.telegrambackend.AUTH.user_profiles.service;

import org.example.telegrambackend.AUTH.user_profiles.dto.CreateUserProfileRequest;
import org.example.telegrambackend.AUTH.user_profiles.dto.UpdateUserProfileRequest;
import org.example.telegrambackend.AUTH.user_profiles.dto.UserProfileResponse;

import java.util.List;

public interface UserProfileService {
    UserProfileResponse create(Long userId, CreateUserProfileRequest request);
    List<UserProfileResponse> getAll();
    UserProfileResponse getById(Long id);
    UserProfileResponse update(Long id, UpdateUserProfileRequest request);
    void delete(Long id);

}
