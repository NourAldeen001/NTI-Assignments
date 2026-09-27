import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Exercise 1.6 — Passing Behavior Into a Method
//
// TODO 1: Implement transformAll(input, transformer):
//         it should apply "transformer" to every element and return a NEW list.

//
// TODO 2: Call transformAll twice on the "words" list:
//         - once to uppercase every word
//         - once to reverse every word (hint: new StringBuilder(w).reverse().toString())

public class Exercise1_6_TransformAll {

    static List<String> transformAll(List<String> input, Function<String, String> transformer) {
        List<String> result = new ArrayList<>();
        for(String s : input) {
           result.add(transformer.apply(s));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> words = List.of("java", "lambda", "stream");

        Function<String, String> upper = (s) -> s.toUpperCase();
        Function<String, String> reverse = (s) -> new StringBuilder(s).reverse().toString();


        List<String> upperList = Exercise1_6_TransformAll.transformAll(words, upper);
        for(String s : upperList) {
            System.out.println(s);
        }

        List<String> reverseList = Exercise1_6_TransformAll.transformAll(words, reverse);
        for(String s : reverseList) {
            System.out.println(s);
        }
    }
}
