package com.example;

public class Engine {

    private String type = "default-engine";

    public void setType(String type) {
        this.type = type;
    }

    public String toString() { return "Engine[" + type + "]"; }
}
