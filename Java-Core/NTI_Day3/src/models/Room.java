package models;

import services.Service;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {
    // Attributes
    private String roomNumber;
    private double baseRate;
    private List<Service> services = new ArrayList<>();
    private boolean isBooked;
    private Customer customer;


    // Constructors
    public Room(String roomNumber, double baseRate) {
        setRoomNumber(roomNumber);
        setBaseRate(baseRate);
    }

    // Methods
    public abstract String getDescription();

    public void addService(Service service) {
        if(isBooked) {
            services.add(service);
            System.out.println(service.getName() + " Added Successfully");
        }
        else {
            System.out.println("Cannot add service: room is not booked");
        }
    }

    public void addMultipleServices(Service... services) {
        for(Service service : services) {
            addService(service);
        }
    }

    public double getTotalCost() {
        double total = 0;
        if(services.isEmpty()) {
            total = baseRate;
        }
        else {
            for(Service service : services) {
                total += service.getCost();
            }
            total+=baseRate;
        }
        return total;
    }

    public void bookRoom(Customer customer) {
        if(!isBooked) {
            isBooked = true;
            setCustomer(customer);
            System.out.println("Room booked for " + customer + " successfully");
        }
        else {
            System.out.println("Room is already booked, not available");
        }
    }

    public void getBookingDetails() {
        if(isBooked) {
            System.out.println("============= Booking Details ================");
            System.out.println("Description: " + getDescription());
            System.out.println("Customer: " + getCustomer().toString());
            System.out.println("-----Services----");
            for(Service service : services) {
                System.out.println("\t -" + service.getName() + " " + service.getCost());
            }
            System.out.println("----------------");
            System.out.println("Total Cost: " + getTotalCost());
        }
        else {
            System.out.println("This Room is not booked yet");
        }
    }

    // Setters
    public void setRoomNumber(String roomNumber) {
        int rN = Integer.parseInt(roomNumber);
        if(rN < 0) throw new IllegalArgumentException("Base Rate must be positive");
        this.roomNumber = roomNumber;
    }

    public void setBaseRate(double baseRate) {
        if(baseRate < 0) throw new IllegalArgumentException("Base Rate must be positive");
        this.baseRate = baseRate;
    }

    public void setCustomer(Customer customer) {
        if(customer == null) throw new IllegalArgumentException("Customer must be initialized");
        this.customer = customer;
    }

    // Getters
    public String getRoomNumber() {
        return roomNumber;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public List<Service> getServices() {
        return services;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public Customer getCustomer() {
        return customer;
    }
}
