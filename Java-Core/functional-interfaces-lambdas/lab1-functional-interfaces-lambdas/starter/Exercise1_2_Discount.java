// Exercise 1.2 — Write Your Own Functional Interface
//
// TODO 1: Define a functional interface called Discount with one abstract method:
//         double apply(double price);
//
// TODO 2: Implement THREE discounts using ANONYMOUS CLASSES:
//         1. 10% off
//         2. A flat $5 off
//         3. No discount at all
//
// TODO 3: Apply each discount to a $100 item and print the result.

public class Exercise1_2_Discount {

    // TODO 1: define the Discount interface here
    interface Discount {
        double apply(double price);
    }

    public static void main(String[] args) {
        double price = 100;

        // TODO 2 & 3: create the three anonymous class implementations and print results
        Discount dis10percen = new Discount() {
            @Override
            public double apply(double price) {
                return price * 0.25;
            }
        };

        Discount dis5flat = new Discount() {
            @Override
            public double apply(double price) {
                return price - 5;
            }
        };

        Discount freedis = new Discount() {
            @Override
            public double apply(double price) {
                return 0;
            }
        };

        double res1 = dis10percen.apply(120);
        System.out.println("Result: " + res1);

        double res2 = dis5flat.apply(120);
        System.out.println("Result: " + res2);

        double res3 = freedis.apply(120);
        System.out.println("Result: " + res3);
    }
}
