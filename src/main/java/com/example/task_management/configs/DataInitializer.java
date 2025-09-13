package com.example.task_management.configs;

import com.example.task_management.enums.UserRole;
import com.example.task_management.models.Role;
import com.example.task_management.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        // Initialize roles
        if (roleRepository.count() == 0) {
            Role userRole = new Role().setName(UserRole.USER);
            Role adminRole = new Role().setName(UserRole.ADMIN);

            roleRepository.save(userRole);
            roleRepository.save(adminRole);

            System.out.println("Roles initialized successfully");
        }
    }
}