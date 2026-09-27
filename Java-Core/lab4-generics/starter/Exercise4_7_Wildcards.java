import java.io.ObjectStreamException;
import java.util.List;

// Exercise 4.7 — Wildcards: Fix the Compile Error
//
// TODO: Fix printAll's signature using a wildcard so it accepts a list of ANY type,
//       while only reading from it. It currently only accepts List<Object>, which
//       makes the calls in main fail to compile.

public class Exercise4_7_Wildcards {

    public static void printAll(List<?> list) { // TODO: fix this signature
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        printAll(List.of("Ali", "Sara")); // currently fails to compile
        printAll(List.of(1, 2, 3));       // currently fails to compile
    }
}
