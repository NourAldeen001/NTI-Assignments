package org.bank.models;

import org.bank.exceptions.InvalidEmailException;

public class Customer {
    // Attributes
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) throws InvalidEmailException {
        setId(id);
        setName(name);
        setEmail(email);
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        if(name.isBlank()) throw new IllegalArgumentException("Name cannot be empty or blank");
        this.name = name;
    }

    public void setEmail(String email) throws InvalidEmailException {
        if(!email.contains("@")) throw new InvalidEmailException("Email must be contains @");
        this.email = email;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + "(" + id + "," +  email + ")";
    }
}
