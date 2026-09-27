package streams;

import java.util.List;

// Exercise 3.9 — Mini Challenge: Sum of Squares of Numbers > 10
//
// TODO: filter numbers > 10, square them with mapToInt, then sum().

public class Exercise3_9_SumOfSquares {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 12, 8, 3, 20, 15, 7);

        // TODO: implement and print the result
        int res = numbers.stream()
                .filter(s -> s > 10).mapToInt(n -> n*n)
                .reduce(0, (in1, in2) -> in1 + in2);
        System.out.println(res);
        // Expected: 12*12 + 20*20 + 15*15 = 769
    }
}
