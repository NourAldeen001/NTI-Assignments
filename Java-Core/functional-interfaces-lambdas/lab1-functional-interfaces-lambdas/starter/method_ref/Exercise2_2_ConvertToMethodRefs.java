package method_ref;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

// Exercise 2.2 — Convert Lambdas to Method References
//
// TODO: Rewrite each lambda below as a method reference. Uncomment each line
//       and replace the lambda with the equivalent method reference.

public class Exercise2_2_ConvertToMethodRefs {

    public static void main(String[] args) {
        String greeting = "  Hello  ";

        Function<String, Integer> a = s -> Integer.valueOf(s);
        Supplier<String> b = () -> greeting.trim();
        Function<String, Integer> c = s -> s.length();
        Supplier<List<String>> d = () -> new ArrayList<>();
        BinaryOperator<Integer> e = (x, y) -> Math.max(x, y);
        Consumer<String> f = s -> System.out.println(s);
        Function<String, Integer> g = s -> s.hashCode();

        // TODO: replace each lambda above with its equivalent method reference,
        //       then run this main method to confirm the output is unchanged.

        System.out.println(a.apply("42"));
        System.out.println(b.get());
        System.out.println(c.apply("hello"));
        System.out.println(d.get());
        System.out.println(e.apply(3, 7));
        f.accept("printed via reference");
        System.out.println(g.apply("hello"));


        Function<String, Integer> a1 = Integer::valueOf;
        Supplier<String> b1 = greeting::trim;
        Function<String, Integer> c1 = String::length;
        Supplier<List<String>> d1 = ArrayList::new;
        BinaryOperator<Integer> e1 = Math::max;
        Consumer<String> f1 = System.out::println;
        Function<String, Integer> g1 = String::hashCode;

        System.out.println(a1.apply("42"));
        System.out.println(b1.get());
        System.out.println(c1.apply("hello"));
        System.out.println(d1.get());
        System.out.println(e1.apply(3, 7));
        f1.accept("printed via reference");
        System.out.println(g1.apply("hello"));
    }
}
