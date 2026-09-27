package method_ref;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

// Exercise 2.3 — Build a Mini "Pipeline" (No Streams Yet)
//
// TODO 1: Create a Function<String, Double> called "parser" using a METHOD REFERENCE
//         that converts a String to a Double (hint: Double::valueOf)
// TODO 2: Create a Consumer<Double> called "printer" using a METHOD REFERENCE
//         that prints a value (hint: System.out::println)
// TODO 3: Loop over rawPrices, use parser to convert each, then printer to print it.

public class Exercise2_3_MiniPipeline {

    public static void main(String[] args) {
        List<String> rawPrices = List.of("19.99", "5.50", "100.00", "3.25");

        Function<String, Double> parser = Double::valueOf;
        Consumer<Double> printer = System.out::println;

        for(String raw : rawPrices) {
            double r = parser.apply(raw);
            printer.accept(r);
        }

        // TODO 1 & 2: define parser and printer as method references

        // TODO 3: loop over rawPrices and apply parser then printer
    }
}
