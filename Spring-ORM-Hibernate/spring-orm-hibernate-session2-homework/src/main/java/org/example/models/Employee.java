package org.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Employee extends Person {

    @Column(name = "salary")
    private double salary;

    public Employee() { }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
