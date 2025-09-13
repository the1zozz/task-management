package com.example.task_management.enums;

public enum UserRole {
    USER,
    ADMIN;

    @Override
    public String toString() {
        return name();
    }
}