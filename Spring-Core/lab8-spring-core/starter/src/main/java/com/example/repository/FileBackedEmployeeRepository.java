package com.example.repository;

import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
//@Profile("prod")
public class FileBackedEmployeeRepository implements EmployeeRepository {

    private final File file;

    public FileBackedEmployeeRepository(@Value("${employee.file.path:employee-file.txt}") String filePath) {
        this.file = new File(filePath);
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
        }
        catch(IOException ex) {
            throw new RuntimeException("Could not initialize file repo", ex);
        }
    }
    @Override
    public void save(Employee employee) {
        List<Employee> employees = findAll();
        employee.setId(employees.size());
        employees.add(employee);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for(Employee emp : employees) {
                writer.write(emp.getId() + "," + emp.getName() + "," + emp.getDepartment() + "," + emp.getSalary());
                writer.newLine();
            }
        }
        catch(IOException ex) {
            throw new RuntimeException("Error saving employee", ex);
        }
    }

    @Override
    public Optional<Employee> findById(int id) {
        return findAll().stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Employee e = new Employee();
                e.setId(Integer.parseInt(parts[0]));
                e.setName(parts[1]);
                e.setDepartment(parts[2]);
                e.setSalary(Double.parseDouble(parts[3]));
                employees.add(e);
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error Reading employees", ex);
        }
        return employees;
    }
}
