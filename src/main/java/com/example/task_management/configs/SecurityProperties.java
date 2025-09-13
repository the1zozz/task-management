package com.example.task_management.configs;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "app.security")
@Getter
public class SecurityProperties {
    private List<String> whiteList;


    public void setWhiteList(List<String> whiteList) {
        this.whiteList = whiteList;
    }
}
