// Exercise 1.3 — Convert Anonymous Classes to Lambdas
//
// TODO: Rewrite the three Discount implementations from Exercise 1.2 as LAMBDAS instead
//       of anonymous classes. Same behavior, less code.

public class Exercise1_3_DiscountLambdas {

    @FunctionalInterface
    interface Discount {
        double apply(double price);
    }

    public static void main(String[] args) {
        double price = 100;

       Discount dis10percen = (p) -> p * 0.25;


        Discount dis5flat = (p) -> p - 5;

        Discount freedis = (p) -> 0;

        double res1 = dis10percen.apply(120);
        System.out.println("Result: " + res1);

        double res2 = dis5flat.apply(120);
        System.out.println("Result: " + res2);

        double res3 = freedis.apply(120);
        System.out.println("Result: " + res3);

        // TODO: tenPercentOff as a lambda
        // TODO: fiveFlatOff as a lambda
        // TODO: noDiscount as a lambda

        // TODO: print all three results
    }
}
