package org.example.telegrambackend.AUTH.user_profiles.service;

import org.example.telegrambackend.AUTH.user.entity.User;
import org.example.telegrambackend.AUTH.user.repository.UserRepository;
import org.example.telegrambackend.AUTH.user_profiles.dto.CreateUserProfileRequest;
import org.example.telegrambackend.AUTH.user_profiles.dto.UpdateUserProfileRequest;
import org.example.telegrambackend.AUTH.user_profiles.dto.UserProfileResponse;
import org.example.telegrambackend.AUTH.user_profiles.entity.UserProfile;
import org.example.telegrambackend.AUTH.user_profiles.mapper.UserProfileMapper;
import org.example.telegrambackend.AUTH.user_profiles.repository.UserProfileRepository;
import org.example.telegrambackend.common.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class UserProfileServiceImpl implements UserProfileService{
    private final UserProfileRepository profileRepository;
    private final UserProfileMapper mapper;
    private final UserRepository userRepository;

    public UserProfileServiceImpl(UserProfileRepository profileRepository, UserProfileMapper mapper, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserProfileResponse create(Long userId, CreateUserProfileRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("User not found")
                );
        if(profileRepository.existsByDisplayName(request.displayName())){
            throw new RuntimeException("Display name is already exsist");
        }


        UserProfile profile = new UserProfile(
                request.displayName(),
                request.bio(),
                request.avatarUrl(),
                request.birthday()
        );
        profile.setUser(user);
        profile.setCreateAt(LocalDateTime.now());
        profile.setUpdatedAt(LocalDateTime.now());
        UserProfile saveProfile = profileRepository.save(profile);
        return mapper.toResponse(saveProfile);
    }

    @Override
    public List<UserProfileResponse> getAll() {
        return profileRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public UserProfileResponse getById(Long id) {
        UserProfile profile = profileRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Profile not found")
                );
        return mapper.toResponse(profile);
    }

    @Override
    public UserProfileResponse update(Long id, UpdateUserProfileRequest request) {
        UserProfile profile = profileRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Profile not found")
                );
        if(profileRepository.existsByDisplayName(request.displayName())){
            throw new RuntimeException("Display name is already exsist");
        }
        profile.setDisplayName(request.displayName());
        profile.setBio(request.bio());
        profile.setAvatarUrl(request.avatarUrl());
        profile.setDateOfBirth(request.birthday());
        profile.setUpdatedAt(LocalDateTime.now());
        UserProfile profileUpdate = profileRepository.save(profile);
        return mapper.toResponse(profileUpdate);
    }

    @Override
    public void delete(Long id) {
        UserProfile profile = profileRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Profile not found")
                );
        profileRepository.deleteById(id);
    }
}
