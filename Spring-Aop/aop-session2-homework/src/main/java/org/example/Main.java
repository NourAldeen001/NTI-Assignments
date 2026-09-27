package org.example;

import org.example.config.AppConfig;
import org.example.service.AccountService;
import org.example.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        AccountService accountService = (AccountService) context.getBean("accountService");
//        accountService.deposit("A-1", 150.5);
//        System.out.println("===========================================================");
//        accountService.withdraw("A-12", 52.5);
//        System.out.println("===========================================================");
//        accountService.getBalance();
//        System.out.println("===========================================================");
//        accountService.willThrowException();

        OrderService orderS = (OrderService) context.getBean("orderService");
        System.out.println(orderS.getClass());
//        orderS.getOrder("1");
//        System.out.println("+=======================================+");
//        orderS.getOrder("1");

        orderS.processOrder("1");
        orderS.processOrder("1");



    }
}