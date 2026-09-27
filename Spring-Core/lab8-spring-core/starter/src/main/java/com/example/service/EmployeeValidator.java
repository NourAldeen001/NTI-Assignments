package com.example.service;

import com.example.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {

    public void validate(Employee employee) {
        if(employee != null) {
            if(employee.getSalary() < 0) {
                throw new InvalidEmployeeException("Salary cannot be negative");
            }
            if(employee.getDepartment().trim().isEmpty()) {
                throw new InvalidEmployeeException("Department cannot be empty or blank");
            }
            if(employee.getName().trim().isEmpty()) {
                throw new InvalidEmployeeException("Name cannot be empty or blank");
            }
            System.out.println("Valid..");
        }
        else {
            throw new InvalidEmployeeException("Employee cannot be null");
        }
    }
}
