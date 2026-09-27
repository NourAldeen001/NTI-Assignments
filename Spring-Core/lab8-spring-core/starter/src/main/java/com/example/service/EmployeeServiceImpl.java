package com.example.service;

import com.example.audit.AuditLogger;
import com.example.model.Employee;
import com.example.notify.NotificationManager;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DependsOn("notificationManager")
public class EmployeeServiceImpl implements EmployeeService {

    @Value("#{T(Double).parseDouble('${raise.max-percentage}')}")
    Integer raiseMaxPercent;

    private final EmployeeRepository employeeRepository;
    private final NotificationManager notificationManager;
    private final EmployeeValidator validator;
    private final AuditLogger auditLogger;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, // @Qualifier("inMemoryEmployeeRepository")
                               NotificationManager notificationManager,
                               EmployeeValidator validator,
                               AuditLogger auditLogger) {
        this.employeeRepository = employeeRepository;
        this.notificationManager = notificationManager;
        this.validator = validator;
        this.auditLogger = auditLogger;
    }

    public void addEmployee(Employee employee) {
        auditLogger.log();
        validator.validate(employee);
        employeeRepository.save(employee);
        notificationManager.notify("New Employee Added Successfully");
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void giveRaise(int id, double percentage) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee != null) {
            if(percentage < raiseMaxPercent) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * (percentage/100.0));
                validator.validate(employee);
                notificationManager.notify("Got raise| now salary is : " + employee.getSalary());
            }
            else {
                notificationManager.notify("Ops! you exceed max raise percentage!!");
            }
        }
        else {
            System.out.println("Employee not found");
        }
    }
}
