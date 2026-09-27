package com.example;

import com.example.config.AppConfig;
import com.example.model.Employee;
import com.example.service.EmployeeServiceImpl;
import com.example.service.WelcomeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.getEnvironment().addActiveProfile("prod");
        context.registerBean(AppConfig.class);
        context.registerShutdownHook();
        context.refresh();


        WelcomeService welcomeSer = (WelcomeService) context.getBean("welcomeService", WelcomeService.class);

        EmployeeServiceImpl employeeService = (EmployeeServiceImpl) context.getBean("employeeServiceImpl");
        employeeService.addEmployee(new Employee("Hossam", "IT", 140));
        employeeService.addEmployee(new Employee("Nour", "CS", 120000));
        System.out.println(employeeService.getEmployeeById(1).toString());
        employeeService.getAllEmployees().forEach(e -> System.out.println(e.toString()));
        employeeService.giveRaise(1, 12);

        context.close();

    }
}
