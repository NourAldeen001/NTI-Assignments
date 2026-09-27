package com.example;

public class VehicleInstanceFactory {
    public Vehicle createSedan() {
        Vehicle v = new Vehicle();
        v.setColor("black");
        return v;
    }
}
