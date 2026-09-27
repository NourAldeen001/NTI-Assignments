package org.example.repository;

import org.example.model.Priority;
import org.example.model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TaskRepository {

    private Long autoId = 1L;

    private final List<Task> tasks = new ArrayList<>();

    public void save(Task task) {
        if(task != null) {
            System.out.println("id: " + autoId);
            task.setId(autoId);
            tasks.add(task);
            autoId++;
        }
    }

    public Optional<Task> findById(Long id) {
        return tasks.stream().filter(task -> Objects.equals(task.getId(), id)).findFirst();
    }

    public List<Task> findByPriority(Priority priority) {
        return tasks.stream()
                .filter(t -> t.getPriority() == priority)
                .collect(Collectors.toList());
    }

    public List<Task> findAll() {
        return tasks;
    }

    public void deleteById(Long id) {
        tasks.remove(Math.toIntExact(id));
    }
}
