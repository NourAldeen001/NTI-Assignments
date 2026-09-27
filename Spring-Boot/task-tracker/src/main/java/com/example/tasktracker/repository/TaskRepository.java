package com.example.tasktracker.repository;

import com.example.tasktracker.config.TaskTrackerProperties;
import com.example.tasktracker.entity.Task;
import com.example.tasktracker.exception.MaxLimitExceededException;
import com.example.tasktracker.exception.TaskNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class TaskRepository {

    private final Logger log = LoggerFactory.getLogger(TaskRepository.class);

    private TaskTrackerProperties properties;

    @Value("${app.max-tasks}")
    public int maxTasks;
    private AtomicLong aLong = new AtomicLong();
    private List<Task> tasks = new ArrayList<>();

    public TaskRepository(TaskTrackerProperties properties) {
        this.properties = properties;
        log.info("name: {} , maxTasks: {}, and defaultPageSize: {}",
                properties.name(), properties.maxTasks(), properties.defaultPageSize());
    }

    public Task save(Task task) {
        log.info("Saving Task ...");
        Task res = null;
        if(tasks.size() != maxTasks) {
            task.setId(aLong.get());
             res = task;
            tasks.add(task);
            aLong.incrementAndGet();
            log.info("Task: {} saved successfully", task);
        }
        else {
            log.warn("You exceed task size limit > {}", maxTasks);
            throw new MaxLimitExceededException("max size cannot be more than " + maxTasks);
        }
        return res;
    }

    public Task findById(Long id) {
        log.debug("Finding Task with id: {}", id);
        Task task = null;
        if((tasks.size() - 1) > id) {
            task = tasks.get(Math.toIntExact(id));
        }
        if (task != null) {
            log.debug("Task with id: {} returned successfully", id);
            return task;
        }
        else {
            log.warn("Task with id: {} not found", id);
            throw new TaskNotFoundException(id);
        }
    }

    public List<Task> findAll() {
        return tasks;
    }

    public List<Task> findByCompleted(boolean completed) {
        return tasks.stream()
                .filter(Task::isCompleted)
                .collect(Collectors.toList());
    }

    public Task update(Long id, Task newTask) {
        log.info("Updating Task ...");
        Task found = findById(id);
        found.setTitle(newTask.getTitle());
        found.setCompleted(newTask.isCompleted());
        found.setDescription(newTask.getDescription());
        found.setDueDate(LocalDate.now());
        log.info("Task wih id: {} updated successfully", id);
        return found;
    }

    public boolean markAsCompleted(Long id) {
        Task found = findById(id);
        boolean res = !found.isCompleted();
        found.setCompleted(res);
        return res;
    }

    public void deleteById(Long id) {
        log.info("Deleting Task ...");
        Task found = findById(id);
        tasks.remove(found);
        log.info("Task wih id: {} deleted successfully", id);
    }

}