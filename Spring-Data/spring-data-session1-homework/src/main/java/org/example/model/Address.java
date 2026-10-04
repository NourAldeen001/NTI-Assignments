package org.example.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String city;
    private String country;

    public Address() { }

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }
}
