package org.example.telegrambackend.AUTH.user.mapper;

import org.example.telegrambackend.AUTH.user.dto.UserResponse;
import org.example.telegrambackend.AUTH.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponse toResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getCreateAt(),
                user.getUpdatedAt(),
                user.getLastSeenAt()
        );
    }
}
