package com.example.repository;

import com.example.conditions.OnDevProfileCondition;
import com.example.model.Employee;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//@Profile("dev")
//@Conditional(OnDevProfileCondition.class)
public class InMemoryEmployeeRepository implements EmployeeRepository {

    private final List<Employee> employees;

    public InMemoryEmployeeRepository(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public void save(Employee employee) {
        System.out.println("InMemoryEmployeeRepository");
        employee.setId(employees.size());
        employees.add(employee);
    }

    @Override
    public Optional<Employee> findById(int id) {
        Optional<Employee> employee = Optional.ofNullable(employees.get(id));
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }
}
