package com.example;

public class SportsCar extends Vehicle {

    private boolean sportMode = true;

    @Override
    public String toString() {
        return "SportsCar[color=" + getColor() + ", engine=" + getEngine() + ", sportMode=" + sportMode + "]";
    }

    public boolean isSportMode() {
        return sportMode;
    }

    public void setSportMode(boolean sportMode) {
        this.sportMode = sportMode;
    }
}
