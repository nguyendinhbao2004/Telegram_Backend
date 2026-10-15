package org.example.telegrambackend.AUTH.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.telegrambackend.AUTH.user.dto.CreateUserRequest;
import org.example.telegrambackend.AUTH.user.dto.UpdateUserRequest;
import org.example.telegrambackend.AUTH.user.dto.UserResponse;
import org.example.telegrambackend.AUTH.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@SecurityRequirement(name = "bearerAuth")
@RequiredArgsConstructor
@Tag(
        name = "User",
        description = "User management APIs"
)
public class UserController {
    private final UserService userService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Create a new user",
            description = "Create a new user account"
    )
    public UserResponse create(@Valid @RequestBody CreateUserRequest request){
        return userService.create(request);
    }

    @GetMapping
    @Operation(
            summary = "Get all users",
            description = "Retrieve all users"
    )
    public List<UserResponse> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get user by ID",
            description = "Retrieve a user by their ID"
    )
    public UserResponse getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update user",
            description = "Update username and email of an existing user"
    )
    public UserResponse update(@PathVariable Long id, @RequestBody UpdateUserRequest request){
        return userService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete user",
            description = "Delete a user by ID"
    )
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

}
