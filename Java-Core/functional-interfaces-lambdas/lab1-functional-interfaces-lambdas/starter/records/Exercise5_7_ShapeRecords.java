package records;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;

// Exercise 5.7 — Records Implementing an Interface
//
// TODO 1: Define Circle(double radius) and Rectangle(double width, double height)
//         records implementing Shape.
// TODO 2: Put both in a List<Shape> and sum the areas using streams.

interface Shape {
    double area();
}

// TODO 1: define Circle and Rectangle records implementing Shape
record Circle(double radius) implements Shape {
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

record Rectangle(double width, double height) implements Shape {
    @Override
    public double area() {
        return width * height;
    }
}

public class Exercise5_7_ShapeRecords {
    public static void main(String[] args) {
        // TODO 2: build a List<Shape> and sum the areas using streams
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(10, 20));
        shapes.add(new Circle(10));

        double res = shapes.stream().map(Shape::area).reduce((double) 0, (a, b) -> a+b);
        System.out.println(res);

    }
}
