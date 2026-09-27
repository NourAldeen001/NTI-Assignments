package method_ref;

import java.util.function.BiFunction;

// Exercise 2.5 — Debugging Challenge (Trickiest One)
//
// TODO: Before running this, PREDICT what "result" will be, and whether this
//       even compiles. Then run it and check your prediction.
//       Write your reasoning as a comment below explaining which of the
//       4 method reference types String::concat is using.

public class Exercise2_5_DebuggingChallenge {

    public static void main(String[] args) {
        BiFunction<String, String, String> concat = String::concat;

        String result = concat.apply("Hello, ", "World");
        System.out.println(result);

        // TODO: write your explanation here as a comment
        /**
         * (BiFunction) Functional Interface takes Two "Hello, " and "World" as input Strings
         * Then makes Concat Them into One String "Hello, World" as result
          */
    }
}
