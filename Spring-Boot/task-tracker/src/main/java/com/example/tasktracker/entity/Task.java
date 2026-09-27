package com.example.tasktracker.entity;

import com.example.tasktracker.exception.ArgumentNotValidException;

import java.time.LocalDate;

public class Task {

    private Long id;
    private String title;
    private String description = "";
    private boolean completed = false;
    private LocalDate dueDate = LocalDate.now();

    public Task() { }

    public Task(String title) {
        setTitle(title);
        this.description = "";
        this.completed = false;
        this.dueDate = LocalDate.now();
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
        if(title != null && !title.trim().isEmpty()) {
            this.title = title;
            return;
        }
        throw new ArgumentNotValidException("Title cannot be empty or blank");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", dueDate=" + dueDate +
                '}';
    }
}
