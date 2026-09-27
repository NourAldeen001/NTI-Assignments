package com.example.tasktracker;

import com.example.tasktracker.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TaskTrackerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TaskTrackerApplication.class, args);

	}

    @Bean
    public CommandLineRunner commandLineRunner(TaskRepository taskRepository) {
        return args -> {
            System.out.println("na: " + taskRepository.maxTasks);
        };
    }

}
