package org.example.telegrambackend.AUTH.user.service;

import org.example.telegrambackend.AUTH.user.dto.CreateUserRequest;
import org.example.telegrambackend.AUTH.user.dto.UpdateUserRequest;
import org.example.telegrambackend.AUTH.user.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create(CreateUserRequest request);
    List<UserResponse> getAll();
    UserResponse getById(Long id);

    UserResponse update(Long id, UpdateUserRequest request);

    void delete(Long id);
}
