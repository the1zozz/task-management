package com.example.task_management.repository;

import com.example.task_management.enums.UserRole;
import com.example.task_management.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(UserRole roleName);

}
