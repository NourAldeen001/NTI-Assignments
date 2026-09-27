package streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Exercise 3.8 — Collectors.groupingBy and joining
//
// TODO 1: Group product names by category -> Map<String, List<String>>
// TODO 2: Produce a single comma-separated string of ALL product names, sorted alphabetically

public class Exercise3_8_GroupingByJoining {

    static class Product {
        String name;
        double price;
        String category;

        Product(String name, double price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }
    }

    public static void main(String[] args) {
        List<Product> products = List.of(
            new Product("Mouse", 25.0, "Accessories"),
            new Product("Keyboard", 60.0, "Accessories"),
            new Product("Monitor", 200.0, "Displays"),
            new Product("Cable", 10.0, "Accessories")
        );

        // TODO 1: groupingBy category, mapping to names
        Map<String, List<Product>> gr = products.stream()
                .collect(Collectors.groupingBy(product -> product.category));

        for(Map.Entry<String, List<Product>> entry : gr.entrySet()) {
            System.out.println(entry.getKey());
            for(Product p : entry.getValue()) {
                System.out.println(p.name);
            }
        }

        // TODO 2: joining all names, sorted, comma-separated
        String a = products.stream()
                .map(product -> product.name).collect(Collectors.joining(", "));
        System.out.println(a);
    }
}
