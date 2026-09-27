package org.example.controller;

import jakarta.validation.Valid;
import org.example.exception.TaskNotFoundException;
import org.example.model.Priority;
import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @PostMapping
    public String addTask(@Valid Task task, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            return "task-form";
        }

        taskRepository.save(task);
        redirectAttributes.addFlashAttribute("successMessage", "Task Added Successfully!");
        return "index";
    }

    @GetMapping("/{id}")
    public String getTaskById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("task", taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id)));
        return "task-detail";
    }

    @GetMapping("/search")
    public String getTaskByPriority(@RequestParam("priority") String priority, Model model) {
        model.addAttribute("tasks", taskRepository.findByPriority(Priority.valueOf(priority)));
        return "task-list";
    }

    @GetMapping
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "task-list";
    }


}
