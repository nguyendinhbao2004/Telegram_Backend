package org.example.telegrambackend.AUTH.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UpdateUserRequest (
        @NotBlank(message = "Usser name is require")
        @Size(min = 5, max = 10, message = "Username must be between 5 and 10 characters")
        String username,
        @NotBlank(message = "Email is required")
        @Email(message = "Email is invalid")
        String email,

        @NotBlank(message = "phone is required")
        @Size(min = 10, max = 11, message = "Phone number must be between 10 and 11 number")
        @Pattern(
                regexp = "^\\+?[0-9]{10,11}$",
                message = "Phone number is invalid"
        )
        String phonenumber
){
}
