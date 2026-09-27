package records;

import java.util.HashSet;
import java.util.Set;

// Exercise 5.1 — Your First Record
//
// TODO 1: Define a record Point(int x, int y).
// TODO 2: Create two points with the same coordinates and demonstrate:
//         - equals() returns true
//         - hashCode() matches
//         - toString() prints "Point[x=..., y=...]"
//         - HashSet correctly deduplicates them

// TODO 1: define record Point
record Point(int x, int y){}

public class Exercise5_1_FirstRecord {

    public static void main(String[] args) {
        // TODO 2: test equals/hashCode/toString/HashSet
        Point p1 = new Point(12, 12);
        Point p2 = new Point(12, 12);

        System.out.println(p1 == p2);
        System.out.println("equals(): " + p2.equals(p1));
        System.out.println("hashCode(): " + (p2.hashCode() == p1.hashCode()));
        System.out.println("P1 toString(): " + p1);
        System.out.println("P2 toString(): " + p2);

        Set<Point> points = new HashSet<>();
        points.add(p1);
        points.add(p2);

        System.out.println(points.size());


    }
}
