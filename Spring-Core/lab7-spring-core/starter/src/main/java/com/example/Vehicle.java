package com.example;

public class Vehicle {
    private String color;
    private Engine engine;

    public void setColor(String color) {
        this.color = color;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine;
    }

    public String toString() {
        return "Vehicle[color=" + color + ", engine=" + engine + "]";
    }

    public void create() {
        System.out.println("Create");
    }

    public void destroy() {
        System.out.println("Destroy");
    }
}
