package org.example.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public String handleNotFound(TaskNotFoundException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "error";
    }
}
