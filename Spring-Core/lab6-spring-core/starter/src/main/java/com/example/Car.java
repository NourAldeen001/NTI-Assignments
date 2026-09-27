package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Exercises 6.2 (constructor injection), 6.3 (setter injection),
// 6.4 (simple values), 6.6 (Notifier dependency)
//
// NOTE: pick ONE injection style (constructor OR setter) as you work through
// the exercises in order - the guide shows both versions separately.
public class Car {

    private String model;
    private int year;
    private Engine engine;
    private final Notifier notifier;

    // TODO (6.2/6.3): add an Engine field (constructor or setter injection)
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    // TODO (6.4): add model (String) and year (int) fields with setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // TODO (6.6): add a Notifier field via constructor injection
    @Autowired
    public Car(Notifier notifier) {
        this.notifier = notifier;
    }


    public void drive() {
        // TODO: call engine.start()
        engine.start();
        // TODO (6.4): print "Driving a <year> <model>"
        System.out.println("Driving a " + year + " " + model);
        // TODO (6.6): call notifier.send("Car started driving")
        //notifier.send("HHHH");
        System.out.println("Car is driving");
    }
}
