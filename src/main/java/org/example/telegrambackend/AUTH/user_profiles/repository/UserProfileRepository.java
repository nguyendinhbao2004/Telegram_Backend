package org.example.telegrambackend.AUTH.user_profiles.repository;

import org.example.telegrambackend.AUTH.user_profiles.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByDisplayName(String displayName);
    Optional<UserProfile> findByBio(String bio);
    boolean existsByDisplayName(String displayName);
}
