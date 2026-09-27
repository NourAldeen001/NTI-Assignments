package com.example;

import org.springframework.stereotype.Component;

// Exercises 6.2, 6.5, 6.7 — Constructor Injection, Singleton Scope, Eager Loading
public class Engine {

    public Engine() {
        // TODO (6.7): print "Engine bean created" here
        System.out.println("Engine bean created");
    }

    public void start() {
        // TODO (6.2): print "Engine started"
        System.out.println("Engine started");
    }
}
