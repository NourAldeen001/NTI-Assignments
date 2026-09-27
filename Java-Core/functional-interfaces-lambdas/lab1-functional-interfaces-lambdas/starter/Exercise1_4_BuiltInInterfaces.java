import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// Exercise 1.4 — Using Built-in Functional Interfaces
//
// TODO 1: Write a Predicate<String> called isLongWord that checks if a word has more than 5 characters.
// TODO 2: Write a Function<String, String> called shout that uppercases a string and appends "!".
// TODO 3: Write a Consumer<String> called logIt that prints "LOG: " + value.
// TODO 4: Write a Supplier<String> called randomGreeting that returns a greeting string.
// TODO 5: Loop over the words list, and for every word that passes isLongWord,
//         apply shout, then pass the result to logIt.


public class Exercise1_4_BuiltInInterfaces {

    public static void main(String[] args) {
        List<String> words = List.of("cat", "elephant", "dog", "hippopotamus");

        Predicate<String> isLongWord = (s) -> s.length() > 5;

        Function<String, String> shout = (s) -> s.toUpperCase() + "!";

        Consumer<String> logIt = (val) -> System.out.println("LOG: " + val);

        Supplier<String> randomGreeting = () -> "Hello";


        words.forEach(w -> {
            randomGreeting.get();
            if(isLongWord.test(w)) {
                String s = shout.apply(w);
                logIt.accept(s);
            }
        });

        // TODO 1-4: define isLongWord, shout, logIt, randomGreeting here

        // TODO 5: loop over words and combine the functional interfaces
    }
}
