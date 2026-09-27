package com.example.tasktracker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public record TaskTrackerProperties(
        String name,
        int maxTasks,
        int defaultPageSize
) {}
