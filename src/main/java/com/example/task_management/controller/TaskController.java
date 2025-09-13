package com.example.task_management.controller;

import com.example.task_management.dto.taskDto.TaskRqDto;
import com.example.task_management.dto.taskDto.TaskRsDto;
import com.example.task_management.models.User;
import com.example.task_management.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@SecurityRequirement(name = "Bearer Authentication")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    @Operation(summary = "Get List of Tasks" ,
            description = "Retrieve all tasks associated with authenticated user")
    public ResponseEntity<List<TaskRsDto>> getAllTasks(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(taskService.getAllTasks(user.getId()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Task by ID" ,
            description = "Retrieve a specific task by its ID")
    public ResponseEntity<TaskRsDto> getTaskById(@AuthenticationPrincipal User user ,
                                                 @PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(user.getId(),id));
    }

    @PostMapping
    @Operation(summary = "Create a new task" ,
            description = "Create a new task associated with authenticated user")
    public ResponseEntity<TaskRsDto> createTask(@AuthenticationPrincipal User user ,
                                                @RequestBody TaskRqDto taskRqDto) {
        return ResponseEntity.ok(taskService.createTask(user.getId(),taskRqDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a task" ,
            description = "Update a specific task by its ID")
    public ResponseEntity<TaskRsDto> updateTask(@AuthenticationPrincipal User user ,
                                                @PathVariable Long id,
                                                @RequestBody TaskRqDto taskRqDto) {
        return ResponseEntity.ok(taskService.updateTask(user.getId(),id,taskRqDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a task" ,
            description = "Delete a specific task by its ID")
    public ResponseEntity<String> deleteTask(@AuthenticationPrincipal User user ,
                                            @PathVariable Long id) {
        taskService.deleteTask(user.getId(),id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}
