import java.util.ArrayList;
import java.util.List;

// Exercise 4.9 — Type Erasure: Predict the Output
//
// TODO: Before running, write your prediction as a comment below.
//       Then run this file and check whether you were right.

public class Exercise4_9_TypeErasure {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        System.out.println(strings.getClass() == integers.getClass());
        System.out.println(strings.getClass().getName());

        // TODO: write your prediction + explanation as a comment here
        /**
         * Because we have List<T> where is still same blueprint or template for create objects
         * */
    }
}
