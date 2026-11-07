package org.example.telegrambackend.service;

import org.example.telegrambackend.dto.UserResponse;

public interface UserSettingService {
    UserResponse getUerSettingsById(Long id);
}
