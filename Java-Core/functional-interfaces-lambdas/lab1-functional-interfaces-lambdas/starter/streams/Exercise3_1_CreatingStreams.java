package streams;// Exercise 3.1 — Creating Streams
//
// TODO 1: Create a stream from a List<String> of 3 programming languages and print each.
// TODO 2: Create a stream of integers 1-10 using IntStream.rangeClosed and print each.
// TODO 3: Create an infinite stream of even numbers starting at 0, limited to the first 6, and print each.

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise3_1_CreatingStreams {

    public static void main(String[] args) {

        List<String> progLanguages = List.of("Java", "Kotlin", "GO");

        // TODO 1
        Stream<String> progStream = progLanguages.stream();
        progStream.iterator().forEachRemaining(System.out::println);
        // TODO 2
        IntStream.rangeClosed(1, 10).forEach(System.out::println);
        // TODO 3
        IntStream.rangeClosed(1, 6).filter(n -> n%2==0).forEach(System.out::println);
    }
}
