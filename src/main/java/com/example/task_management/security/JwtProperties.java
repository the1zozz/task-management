package com.example.task_management.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "security.jwt")
@Component
@Getter
@Setter
public class JwtProperties {
    private String secretKey;
    private long expirationTime;
}
