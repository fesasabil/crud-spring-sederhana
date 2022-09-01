package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper implements BaseMapper<User, UserDto> {

    private final PasswordEncoder passwordEncoder;

    @Override
    public User toEntity(UserDto dto) {
        return null;
    }

    @Override
    public UserDto toDto(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .is_active(entity.getIs_active())
                .build();
    }

    @Override
    public List<User> toEntities(List<UserDto> dtos) {
        return null;
    }

    @Override
    public List<UserDto> toDtos(List<User> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public User fromRequest(UserRequest request) {
        return User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .is_active(request.getIs_active())
                .build();
    }
}
