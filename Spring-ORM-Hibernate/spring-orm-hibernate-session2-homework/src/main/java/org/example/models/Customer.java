package org.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Customer extends Person {

    @Column(name = "loyalty_level")
    private String loyaltyLevel;

    public Customer() { }

    public String getLoyaltyLevel() {
        return loyaltyLevel;
    }

    public void setLoyaltyLevel(String loyaltyLevel) {
        this.loyaltyLevel = loyaltyLevel;
    }

}
