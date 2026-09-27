package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("=== Exercise 6.1 ===");
        // TODO: get "greeter" bean, call greet()
        Greeter g = (Greeter) context.getBean("greeter");
        g.greet();


        System.out.println("=== Exercise 6.2 / 6.3 / 6.4 / 6.6 ===");
        // TODO: get "car" bean, call drive()
        Car c = (Car) context.getBean("car");
        c.drive();

        System.out.println("=== Exercise 6.5 ===");
        // TODO: get "engine" bean twice, compare with ==
        Engine engine1 = (Engine) context.getBean("engine");
        Engine engine2 = (Engine) context.getBean("engine");
        System.out.println(engine1.equals(engine2));
        System.out.println(engine1 == engine2);

        System.out.println("=== Exercise 6.8 (Capstone) ===");
        // TODO: get "orderService" bean, call placeOrder(250.0)
        OrderService orderService = (OrderService) context.getBean("orderService");
        orderService.placeOrder(20);

    }
}
