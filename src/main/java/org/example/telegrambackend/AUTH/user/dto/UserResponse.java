package org.example.telegrambackend.AUTH.user.dto;

import java.time.LocalDateTime;

public record UserResponse (
        Long id,
        String username,
        String email,
        String phone,
        LocalDateTime createat,
        LocalDateTime updateat,
        LocalDateTime lastseenat
){
}
