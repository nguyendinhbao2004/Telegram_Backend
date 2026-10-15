package org.example.telegrambackend.AUTH.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
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
        String phonenumber,

        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).+$",
                message = "Password must contain uppercase, lowercase, number and special character"
        )
        String password
) {

}
