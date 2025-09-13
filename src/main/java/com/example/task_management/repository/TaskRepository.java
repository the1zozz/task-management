package com.example.task_management.repository;

import com.example.task_management.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUserId(Long id);

    Optional<Task> findByIdAndUserId(Long id, Long userId);
}
