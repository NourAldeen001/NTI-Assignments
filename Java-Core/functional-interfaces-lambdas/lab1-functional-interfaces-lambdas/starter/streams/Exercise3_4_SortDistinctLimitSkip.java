package streams;

import java.util.Comparator;
import java.util.List;

// Exercise 3.4 — sorted, distinct, limit, skip
//
// TODO: In ONE pipeline: remove duplicates, sort ascending, skip the first 2, take the next 3.

public class Exercise3_4_SortDistinctLimitSkip {

    public static void main(String[] args) {
        List<Integer> nums = List.of(5, 3, 8, 3, 9, 1, 5, 8, 2);
        // 5 3 8 9 1 2
        // 1 2 3 5 8 9
        // 3 5 8 9
        // | | |

        // TODO: chain distinct -> sorted -> skip -> limit, then print the result
        nums.stream().distinct().sorted().skip(2).limit(3).forEach(System.out::println);
    }
}
