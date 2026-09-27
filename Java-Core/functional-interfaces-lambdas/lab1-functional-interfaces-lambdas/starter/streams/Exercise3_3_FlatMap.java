package streams;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Exercise 3.3 — flatMap
//
// TODO: Flatten the list of teams into a single flat List<String> of all members.

public class Exercise3_3_FlatMap {

    public static void main(String[] args) {
        List<List<String>> teams = List.of(
            List.of("Ali", "Sara"),
            List.of("Omar"),
            List.of("Lina", "Ahmed", "Nour")
        );

        // TODO: flatMap into one flat list, then print it
        List<String> allMemInTeams = teams.stream().flatMap(strings -> strings.stream()).collect(Collectors.toList());
        allMemInTeams.forEach(System.out::println);
    }
}
