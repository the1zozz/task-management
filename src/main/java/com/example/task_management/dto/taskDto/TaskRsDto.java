package com.example.task_management.dto.taskDto;

public record TaskRsDto(
        Long id,
        String title,
        String description,
        String status
) {}
