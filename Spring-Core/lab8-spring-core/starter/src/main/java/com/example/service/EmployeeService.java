package com.example.service;

import com.example.model.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployees();

    void giveRaise(int id, double percentage);
}
