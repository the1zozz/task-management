package com.example.task_management.services;

import com.example.task_management.dto.taskDto.TaskRqDto;
import com.example.task_management.dto.taskDto.TaskRsDto;
import com.example.task_management.mapper.TaskMapper;
import com.example.task_management.models.Task;
import com.example.task_management.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskMapper taskMapper;


    public List<TaskRsDto> getAllTasks(Long userId) {
        List<Task> tasks = taskRepository.findAllByUserId(userId);
        return tasks.stream().map(taskMapper::toDto).toList();
    }

    public TaskRsDto getTaskById(Long userId, Long taskId) {
        Task task = taskRepository.findByIdAndUserId(taskId,userId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        return taskMapper.toDto(task);
    }

    public TaskRsDto createTask(Long userId, TaskRqDto taskRqDto) {
        Task task = taskMapper.toEntity(taskRqDto);
        task.setUserId(userId);
        return taskMapper.toDto(taskRepository.save(task));
    }

    public TaskRsDto updateTask(Long userId, Long taskId, TaskRqDto taskRqDto) {
        Task task = taskRepository.findByIdAndUserId(taskId,userId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskMapper.entity(task,taskRqDto);
        return taskMapper.toDto(taskRepository.save(task));
    }
    public void deleteTask(Long userId, Long taskId) {
        Task task = taskRepository.findByIdAndUserId(taskId,userId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);
    }
}
