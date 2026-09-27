package models;

import exceptions.InvalidEmailException;

public class Customer {
    // Attributes
    private String name;
    private String email;
    private String phoneNumber;

    // Constructors
    public Customer() {}

    public Customer(String name, String email, String phoneNumber) {
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    // toString() Method
    @Override
    public String toString() {
        return "models.Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    // Setters
    public void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty or blank");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if(email == null || email.isBlank()) {
            throw new InvalidEmailException("Email must not be empty or blank");
        }
        else if(!email.contains("@")) {
            throw new InvalidEmailException("Email must contains @");
        }
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.isBlank()){
            throw new IllegalArgumentException("Phone Number must not be empty or blank");
        }
        else if(phoneNumber.length() != 11) {
            throw new IllegalArgumentException("Phone Number must be 11 numbers");
        }
        try {
            int n = Integer.parseInt(phoneNumber);
        }
        catch (NumberFormatException ex) {
            throw new RuntimeException("Phone Number must be contains numbers only");
        }
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
