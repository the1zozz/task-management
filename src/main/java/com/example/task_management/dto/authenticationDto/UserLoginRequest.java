package com.example.task_management.dto.authenticationDto;

public record UserLoginRequest(
        String email,
        String password
) {
}
