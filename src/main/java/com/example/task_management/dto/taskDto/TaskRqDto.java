package com.example.task_management.dto.taskDto;

public record TaskRqDto(
        String title,
        String description,
        String status
) {
}
