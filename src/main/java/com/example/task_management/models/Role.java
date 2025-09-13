package com.example.task_management.models;

import com.example.task_management.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private UserRole name;

    public Role setId(Integer id) {
        this.id = id;
        return this;
    }

    public Role setName(UserRole name) {
        this.name = name;
        return this;
    }
}