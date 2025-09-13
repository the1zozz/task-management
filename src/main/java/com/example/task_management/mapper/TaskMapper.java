package com.example.task_management.mapper;

import com.example.task_management.dto.taskDto.TaskRqDto;
import com.example.task_management.dto.taskDto.TaskRsDto;
import com.example.task_management.models.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toEntity(TaskRqDto taskRqDto);
    TaskRsDto toDto(Task task);
    void entity (@MappingTarget Task task, TaskRqDto taskRqDto);
}
