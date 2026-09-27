import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// Exercise 4.4 — Write a Generic Method: firstElement
//
// TODO 1: Implement a static generic method <T> T firstElement(List<T> list)
//         that returns the first element, throwing NoSuchElementException if empty.
// TODO 2: Test it with a List<String> and a List<Integer>.

public class Exercise4_4_FirstElement {

    // TODO 1: implement firstElement
    public static <T> T firstElement(List<T> list) {
        if(!list.isEmpty()) {
            return list.get(0);
        }
        else {
            throw new NoSuchElementException();
        }
    }

    public static void main(String[] args) {
        // TODO 2: test with List<String> and List<Integer>
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        strings.add("Hello");

        System.out.println(Exercise4_4_FirstElement.firstElement(strings));
        System.out.println(Exercise4_4_FirstElement.firstElement(integers));


    }
}
