import java.util.ArrayList;
import java.util.List;

// Exercise 4.8 — PECS in Practice
//
// TODO 1: Implement copyAll(source, destination) that copies every element from
//         source into destination, using PECS-correct wildcards:
//         - source is a PRODUCER of T -> ? extends T
//         - destination is a CONSUMER of T -> ? super T
// TODO 2: Test it by copying a List<Integer> into a List<Number>.


///  <? extends T> -> accept subclasses(children) of T
///  <? super T> -> accept superclasses(parents) of T

public class Exercise4_8_PECS {

    // TODO 1: implement copyAll
    public static <T> void copyAll(List<? extends T> producer, List<? super T> consumer) {
        for(T t : producer) {
            consumer.add(t);
        }
    }

    public static void main(String[] args) {
        // TODO 2: copy a List<Integer> into a List<Number>
        List<Integer> integers = List.of(1, 5, 7, 9);
        List<Number> numbers = new ArrayList<>();
        System.out.println("Before: " + numbers.size());
        copyAll(integers, numbers);
        System.out.println("After: " + numbers.size());
        numbers.forEach(System.out::println);
    }
}
