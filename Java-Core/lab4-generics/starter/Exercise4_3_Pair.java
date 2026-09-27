import java.util.ArrayList;
import java.util.List;

// Exercise 4.3 — Build a Generic Pair<K, V>
//
// TODO 1: Define a generic class Pair<K, V> with a constructor(K key, V value),
//         getKey(), getValue(), and a toString() like "key -> value".
//
// TODO 2: Build a List<Pair<String, Integer>> for 3 people's (name, age), and print each.

class Pair<K, V> {
    private K key;
    private V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    @Override
    public String toString() {
        return key + " -> " + value;
    }

    public V getValue() {
        return value;
    }
}

public class Exercise4_3_Pair {
    public static void main(String[] args) {
        // TODO 2: build and print the list of pairs
        List<Pair<String, Integer>> nameWithAgeList = new ArrayList<>();
        nameWithAgeList.add(new Pair<>("nour", 12));
        nameWithAgeList.add(new Pair<>("moh", 18));
        nameWithAgeList.add(new Pair<>("ali", 45));

        nameWithAgeList.forEach(pair -> System.out.println(pair.toString()));

    }
}
