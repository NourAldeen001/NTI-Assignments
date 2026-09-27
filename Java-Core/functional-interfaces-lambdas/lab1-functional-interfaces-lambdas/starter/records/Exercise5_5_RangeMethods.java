package records;// Exercise 5.5 — Adding Custom Methods
//
// TODO 1: Define record Range(int min, int max) with a validating compact constructor,
//         plus:
//         - length() returning max - min
//         - contains(int value) returning true if value is within [min, max] inclusive
// TODO 2: Test both methods.

// TODO 1: define Range with length() and contains()
record Range(int min, int max) {
    Range {
        if(min > max)
            throw new IllegalArgumentException("UnKnown");
    }

    public int length() {
        return max - min;
    }

    public boolean contains(int value) {
        return (value <= max && value >= min);
    }
}

public class Exercise5_5_RangeMethods {
    public static void main(String[] args) {
        // TODO 2: test length() and contains()
        Range range = new Range(5, 15);
        System.out.println(range.length());
        System.out.println(range.contains(5));
        System.out.println(range.contains(15));
        System.out.println(range.contains(10));
        System.out.println(range.contains(20));
    }
}
