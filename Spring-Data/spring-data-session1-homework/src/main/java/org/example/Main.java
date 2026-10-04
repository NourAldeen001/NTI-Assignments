package org.example;

import org.example.config.JpaConfig;
import org.example.dto.*;
import org.example.model.Address;
import org.example.model.Category;
import org.example.model.PaymentMethod;
import org.example.model.Product;
import org.example.repository.CategoryRepository;
import org.example.repository.ReportRepository;
import org.example.service.CustomerService;
import org.example.service.OrderService;
import org.example.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {

        org.h2.tools.Server.createWebServer("-web").start();

        try (var context =
                     new AnnotationConfigApplicationContext(JpaConfig.class)) {

            CustomerService customerService = context.getBean(CustomerService.class);

            ProductService productService = context.getBean(ProductService.class);

            OrderService orderService = context.getBean(OrderService.class);

            CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);

            ReportRepository reportRepository = context.getBean(ReportRepository.class);

            System.out.println("========== STORE DEMO ==========");

            // Register customer
            customerService.register(
                    new RegisterRequest(
                            "Nour",
                            "nour@example.com",
                            new Address(
                                    "Ahmed Orabi St",
                                    "Cairo",
                                    "Egypt"
                            )
                    )
            );

            customerService.register(
                    new RegisterRequest(
                            "Mohamed",
                            "mo@example.com",
                            new Address(
                                    "SF Cairo St",
                                    "Cairo",
                                    "Egypt"
                            )
                    )
            );

            System.out.println("Customer registered");

            Category category = new Category();
            category.setName("Electronics");

            categoryRepository.save(category);


            // Add products
            productService.addProduct(
                    new AddProductRequest(
                            "LAP-001",
                            "Laptop",
                            new BigDecimal("25000"),
                            10,
                            "Electronics"
                    )
            );

            productService.addProduct(
                    new AddProductRequest(
                            "MOU-001",
                            "Mouse",
                            new BigDecimal("300"),
                            30,
                            "Electronics"
                    )
            );

            productService.addProduct(
                    new AddProductRequest(
                            "KEY-001",
                            "Keyboard",
                            new BigDecimal("600"),
                            15,
                            "Electronics"
                    )
            );

            System.out.println("Products added");

            // Place order
            orderService.placeOrder(
                    1L,
                    Map.of(
                            1L, 2,
                            2L, 3
                    )
            );

            orderService.placeOrder(
                    2L,
                    Map.of(
                            1L, 1,
                            2L, 5
                    )
            );

            System.out.println("Order created");

            // Place order to throw exception to detect if log added without rollback cause Propagation.REQUIRES_NEW
//            orderService.placeOrder(
//                    1L,
//                    Map.of(
//                            1L, 0
//                    )
//            );
//
//            System.out.println("Logged Without Order created");

            // Pay order
            orderService.pay(
                    1L,
                    PaymentMethod.CARD
            );

            orderService.pay(
                    2L,
                    PaymentMethod.CASH
            );

            System.out.println("Order paid");

            // Ship order
            orderService.ship(1L);

            System.out.println("Order shipped");

            // Summary
            System.out.println("\n========== ORDER SUMMARY ==========");

            System.out.println(
                    orderService.getOrderSummary(1L)
            );

            System.out.println("\n========== REPORTS ==========");

            reportRepository
                    .ordersPerStatus()
                    .forEach((status, count) ->
                            System.out.println(
                                    status + " -> " + count
                            ));

            System.out.println("\nTop Customers");

            reportRepository
                    .topCustomers(5)
                    .forEach(System.out::println);

            System.out.println("\nMonthly Sales");

            reportRepository
                    .monthlySales(2026)
                    .forEach(System.out::println);

            System.out.println("\nProducts Never Ordered");

            reportRepository
                    .productsNeverOrdered()
                    .forEach(p ->
                            System.out.println(
                                    p.getName()
                            ));

            System.out.println("\nApply Discount");

            reportRepository
                    .applyDiscount(
                            "Electronics",
                            10
                    );


            System.out.println("Discount applied");

        }
    }
}
