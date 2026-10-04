package org.example.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Embedded
    private Address shippingAddress;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders = new HashSet<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        if(order != null) {
            order.setCustomer(this);
        }
        orders.add(order);
    }

    public void removeOrder(Order order) {
        if(order != null) {
            order.setCustomer(null);
        }
        orders.remove(order);
    }

}
