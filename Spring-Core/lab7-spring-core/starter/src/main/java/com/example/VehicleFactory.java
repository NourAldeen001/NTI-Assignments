package com.example;

public class VehicleFactory {
    public static Vehicle createSportsCar() {
        Vehicle v = new Vehicle();
        v.setColor("yellow");
        return v;
    }
}
