package org.example;

import org.example.config.AppConfig;
import org.example.service.InventoryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

//        InventoryService invService1 = context.getBean("inventoryService", InventoryService.class);
//        System.out.println(invService1.getClass());
//        invService1.checkStock("DD");
//        invService1.reserveStock("SS", 50);
//        invService1.reserveStock("AA", 105);

        InventoryService invService2 = context.getBean("inventoryServiceWithNameMatchPoint", InventoryService.class);
        System.out.println(invService2.getClass());
        invService2.reserveStock("WW", 50);
        invService2.checkStock("AS");
    }
}