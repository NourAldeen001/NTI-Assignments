package org.example.service;

import org.example.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Cacheable
    public String getOrder(String id) {
        System.out.println("Fetching order " + id + " from the database...");
        return "Order[" + id + "]";
    }

    @Cacheable
    public void processOrder(String id) {

        String order = getOrder(id);
        System.out.println("Processing " + order);
    }
}
