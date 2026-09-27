package streams;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

// Exercise 3.5 — reduce
//
// TODO 1: Use reduce (with identity 0) to compute the total sum of prices.
// TODO 2: Use reduce (no identity) to find the maximum price - result is an Optional.

public class Exercise3_5_Reduce {

    public static void main(String[] args) {
        List<Integer> prices = List.of(20, 15, 30, 10, 25);

        // TODO 1: total sum
       int res = prices.stream().reduce(0, (integer1, integer2) -> integer1 + integer2);
        System.out.println(res);

        // TODO 2: max price via reduce, print using ifPresent
        Optional<Integer> resWithoutIden = prices.stream().reduce((integer1, integer2) -> integer1 + integer2);
        if(resWithoutIden.isPresent()) System.out.println(resWithoutIden.get());

    }
}
