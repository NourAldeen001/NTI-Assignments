import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Exercise 4.6 — Bounded Type Parameter: Generic min for a List
//
// TODO 1: Implement a static generic method <T extends Comparable<T>> T min(List<T> list)
//         that returns the smallest element in a non-empty list.
// TODO 2: Test it with a List<Integer>.

public class Exercise4_6_GenericMin {

    // TODO 1: implement min
    public static <T extends Comparable<T>> T min(List<T> list) {
        Optional<T> s = list.stream().min(Comparable::compareTo);
        if(s.isPresent()) {
            return s.get();
        }
        return s.orElseThrow(RuntimeException::new);
    }

    public static void main(String[] args) {
        // TODO 2: test with a List<Integer>
        List<Integer> integers = new ArrayList<>();
        integers.add(9);
        integers.add(7);
        integers.add(10);
        integers.add(1);

        System.out.println(Exercise4_6_GenericMin.min(integers));
    }
}
