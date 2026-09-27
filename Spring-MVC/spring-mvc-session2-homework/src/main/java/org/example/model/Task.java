package org.example.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Task {

    private Long id;

    @NotBlank(message = "Title cannot be empty or blank")
    private String title;

    @NotNull(message = "Priority cannot be null")
    private Priority priority;

    private boolean completed = false;

    public Task() {
    }

    public Task(String title, boolean completed, Priority priority) {
        this.title = title;
        this.completed = completed;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
