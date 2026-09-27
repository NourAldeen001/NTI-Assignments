// Exercise 4.5 — Bounded Type Parameter: Generic max
//
// TODO 1: Implement a static generic method <T extends Comparable<T>> T max(T a, T b)
//         that returns the larger of the two values.
// TODO 2: Test it with two Integers and two Strings.

public class Exercise4_5_GenericMax {

    // TODO 1: implement max with a bounded type parameter
    public static <T extends Comparable<T>> T max(T a, T b) {
        if(a.compareTo(b) > 0) return a;
        else return b;
    }

    public static void main(String[] args) {
        // TODO 2: test with Integers and Strings
        String s1 = "Hello";
        String s2 = "Welcome";
        System.out.println(Exercise4_5_GenericMax.max(s1, s2));

        Integer i1 = 5;
        Integer i2 = 10;
        System.out.println(Exercise4_5_GenericMax.max(i1, i2));

    }
}
