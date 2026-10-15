package org.example.telegrambackend.AUTH.user.service;

import org.example.telegrambackend.AUTH.user.dto.CreateUserRequest;
import org.example.telegrambackend.AUTH.user.dto.UpdateUserRequest;
import org.example.telegrambackend.AUTH.user.dto.UserResponse;
import org.example.telegrambackend.AUTH.user.entity.User;
import org.example.telegrambackend.AUTH.user.enums.UserStatus;
import org.example.telegrambackend.AUTH.user.mapper.UserMapper;
import org.example.telegrambackend.AUTH.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponse create(CreateUserRequest request) {
        if(userRepository.existsByEmail(request.email())){
            throw new RuntimeException("Email already exist");
        }
        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Email already exists");
        }

        if (userRepository.existsByPhoneNumber(request.phonenumber())) {
            throw new RuntimeException("Phone number already exists");
        }

        User user = new User(
                request.username(),
                request.email(),
                passwordEncoder.encode(request.password()),
                request.phonenumber()
        );
        user.setStatus(UserStatus.ACTIVE);
        user.setCreateAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());


        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponse getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("User not found")
                );
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse update(Long id, UpdateUserRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("User not found")
                );
        if(userRepository.existsByEmail(request.email())){
            throw new RuntimeException("Email already exist");
        }
        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Email already exists");
        }

        if (userRepository.existsByPhoneNumber(request.phonenumber())) {
            throw new RuntimeException("Phone number already exists");
        }
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPhoneNumber(request.phonenumber());
        User updateUser = userRepository.save(user);
        return userMapper.toResponse(updateUser);
    }

    @Override
    public void delete(Long id) {
        if(!userRepository.existsById(id)){
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
}
