package com.example.task_management.dto.authenticationDto;

public record UserRegistrationRequest(
        String name,
        String email,
        String password,
        boolean isAdmin
) {
}
