import java.util.Comparator;
import java.util.List;
import java.util.Optional;

// Exercise 3.7 — findFirst, min, max
//
// TODO 1: Find the first product cheaper than $50.
// TODO 2: Find the cheapest product overall.
// TODO 3: Find the most expensive product overall.

public class Exercise3_7_FindFirstMinMax {

    static class Product {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        List<Product> products = List.of(
            new Product("Mouse", 25.0),
            new Product("Keyboard", 60.0),
            new Product("Monitor", 200.0),
            new Product("Cable", 10.0)
        );

        // TODO 1: findFirst cheaper than $50

        // TODO 2: min by price

        // TODO 3: max by price
    }
}
