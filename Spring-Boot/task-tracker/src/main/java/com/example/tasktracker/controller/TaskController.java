package com.example.tasktracker.controller;

import com.example.tasktracker.entity.Task;
import com.example.tasktracker.repository.TaskRepository;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) { // Tested

        Task saved = taskRepository.save(task);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(location).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(
            @RequestParam(name = "completed", defaultValue = "false", required = false) Boolean completed) { // Tested
        List<Task> res = null;
        if(completed) {
            res = taskRepository.findByCompleted(completed);
        }
        else  {
            res = taskRepository.findAll();
        }
        return ResponseEntity.ok(res);
    }

//    @GetMapping
//    public ResponseEntity<List<Task>> getAllTasksByCompleted(
//            @RequestParam(name = "completed", defaultValue = "true") boolean completed) {
//        return ResponseEntity.ok(taskRepository.findByCompleted(completed));
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable(name = "id") Long id) { // Tested
        return ResponseEntity.ok(taskRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTaskById(@PathVariable(name = "id") Long id, // Tested
                                               @RequestBody Task task) {
        return ResponseEntity.ok(taskRepository.update(id, task));
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<Boolean> updateTaskCompleteStatus(@PathVariable(name = "id") Long id) { // Tested
        return ResponseEntity.ok(taskRepository.markAsCompleted(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable(name = "id") Long id) { // Tested
        taskRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
