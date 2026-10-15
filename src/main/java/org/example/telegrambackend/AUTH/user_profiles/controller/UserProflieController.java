package org.example.telegrambackend.AUTH.user_profiles.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.telegrambackend.AUTH.user_profiles.dto.CreateUserProfileRequest;
import org.example.telegrambackend.AUTH.user_profiles.dto.UserProfileResponse;
import org.example.telegrambackend.AUTH.user_profiles.service.UserProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
@Tag(
        name = "Profile",
        description = "User profile management APIs"
)
public class UserProflieController {
    private final UserProfileService service;

    @PostMapping("/{userId} ")
    @ResponseStatus(HttpStatus.CREATED)
    public UserProfileResponse create(@PathVariable Long userId, @Valid @RequestBody CreateUserProfileRequest request){
        return service.create(userId, request);
    }

    @GetMapping()
    @Operation(
            summary = "Get all users",
            description = "Retrieve all users"
    )
    public List<UserProfileResponse> getAll(){
        return service.getAll();
    }

}
