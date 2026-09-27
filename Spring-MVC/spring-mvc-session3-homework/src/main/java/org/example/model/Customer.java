package org.example.model;

import jakarta.validation.constraints.NotBlank;

public class Customer {

    private Long id;

    @NotBlank(message = "First Name must not be empty or blank")
    private String firstName;

    @NotBlank(message = "Last Name must not be empty or blank")
    private String lastName;

    private String phone;

    public Customer() {

    }

    public Customer(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
