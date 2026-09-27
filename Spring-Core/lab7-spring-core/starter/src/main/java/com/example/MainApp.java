package com.example;

import com.example.partA.OrderService;
import com.example.partA.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Vector;

public class MainApp {
    public static void main(String[] args) {
//        ApplicationContext context =
//            new ClassPathXmlApplicationContext("beanDefinitionContext.xml");

        /// B1
//        Vehicle car = (Vehicle) context.getBean("car");
//        System.out.println(car.toString());
//
//        Vehicle vehicle = (Vehicle) context.getBean("vehicle1");
//        System.out.println(vehicle.toString());
//
//        Vehicle automobile = (Vehicle) context.getBean("automobile");
//        System.out.println(automobile.toString());


        /// B2
        /** Fail Safe: Lazy -> until reach line that is call it
         * Fail Fast: Eager -> when load **/
//        System.out.println("Heelll");
//        Vehicle car = (Vehicle) context.getBean("car");
//
//        Vehicle vehicle = (Vehicle) context.getBean("vehicle1");
//        System.out.println(vehicle == car);

        /// B3
//        Vehicle v1 = (Vehicle) context.getBean("vehicle2");
//        System.out.println(v1.toString());
//
//        Vehicle v2 = (Vehicle) context.getBean("vehicle2");
//        System.out.println(v2.toString());
//
//        System.out.println(v1.equals(v2));
//        System.out.println(v1 == v2);

        /// B4
        // Abstract -> cannot be instantiated
//        Vehicle v1 = (Vehicle) context.getBean("baseVehicle");
//        System.out.println(v1.toString());
//
//        Vehicle v2 = (Vehicle) context.getBean("redCar");
//        System.out.println(v2.toString());
//
//        System.out.println(v1.equals(v2));
//        System.out.println(v1 == v2);

        /// B5
//        Engine v1 = (Engine) context.getBean("engine1");
//        System.out.println(v1.toString());


        /// B6
//        Vehicle v3 = (Vehicle) context.getBean("vehicle3");
//        System.out.println(v3.toString());


        /// B7
//        Vehicle v3 = (Vehicle) context.getBean("vehicle3");
//        System.out.println(v3.toString());


        /// B8
//        Vehicle v3 = (Vehicle) context.getBean("vehicle3");
//        System.out.println(v3.toString());

        /// B9
//        Vehicle v3 = (Vehicle) context.getBean("vehicle3");
//        System.out.println(v3.toString());

        /// B10
//        Vehicle v3 = (Vehicle) context.getBean("vehicle3");
//        System.out.println(v3.toString());

        /// B11
//        Vehicle v3 = (Vehicle) context.getBean("sportsCar");
//        System.out.println(v3.toString());

/// ================================================================================


        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanDefinitionContext.xml");

        context.registerShutdownHook();

        /// A1
//        UserService userS = (UserService) context.getBean("userService");
//        userS.doWork();
//        context.close();

        /// A2
//        UserService userS = (UserService) context.getBean("userService");
//        userS.doWork();
//        context.close();

        /// A3
//        UserService userS = (UserService) context.getBean("userService");
//        userS.doWork();
//        context.close();

        /// A4
//        UserService userS = (UserService) context.getBean("userService");
//        userS.doWork();
//        context.close();

        /// A5
//        UserService userS = (UserService) context.getBean("userService");
//        OrderService orderS = (OrderService) context.getBean("orderService");
//        userS.doWork();
//        context.close();

        /// A6
//        UserService userS1 = (UserService) context.getBean("userService", UserService.class);
//        UserService userS2 = (UserService) context.getBean("userService", UserService.class);
//        System.out.println(System.identityHashCode(userS1));
//        System.out.println(System.identityHashCode(userS2));
//        context.close();

        /// A7
//        UserService userS = (UserService) context.getBean("userService", UserService.class);
//        OrderService orderS = (OrderService) context.getBean("orderService", OrderService.class);
//        context.close();


        /// A8
        UserService userS = (UserService) context.getBean("userService", UserService.class);
        context.close();

    }
}
