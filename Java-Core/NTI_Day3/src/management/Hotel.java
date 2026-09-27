package management;

import exceptions.DuplicateException;
import models.Customer;
import models.Room;
import services.Service;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    // Attributes
    private String hotelName;
    private Map<String, Room> rooms = new HashMap<>();

    // Constructors
    public Hotel(String hotelName) {
        setHotelName(hotelName);
    }


    // Methods
    public Room getRoom(String roomNumber) {
        Room room = null;
        for(Map.Entry<String, Room> entry : rooms.entrySet()) {
            if(entry.getKey().equals(roomNumber)) {
                room = entry.getValue();
            }
        }
        return room;
    }

    public void addRoom(Room room) {
        Room findingRoom = rooms.get(room.getRoomNumber());
        if(findingRoom == null) {
            rooms.put(room.getRoomNumber(), room);
        }
        else {
            throw new DuplicateException("Room is already exists in " + hotelName);
        }
    }

    public void bookRoom(String roomNumber, Customer customer, Service... extras) {
        Room room = rooms.get(roomNumber);
        if(room != null) {
            room.bookRoom(customer);
            for (Service service : extras) {
                room.addService(service);
            }
        }
        else {
            throw new RuntimeException("Room Number is not exists in " + hotelName);
        }

    }

    public void displayBookingDetails(String roomNumber) {
        Room room = rooms.get(roomNumber);
        if(room != null) {
            room.getBookingDetails();
        }
        else {
            throw new RuntimeException("Room Number is not exists in " + hotelName);
        }
    }

    public void displayAllRooms() {
        if(!rooms.isEmpty()) {
            System.out.println("All Rooms in " + hotelName);
            for(Map.Entry<String, Room> entry : rooms.entrySet()) {
                System.out.println("Room Number: " + entry.getKey() + ", Room: " + entry.getValue().toString());
            }
        }
        else {
            System.out.println("Hotel don't arrange rooms yet!");
        }
    }

    public void displayAvailableRooms() {
        if(!rooms.isEmpty()) {
            System.out.println("Available Rooms in " + hotelName);
            for(Map.Entry<String, Room> entry : rooms.entrySet()) {
                if(!entry.getValue().isBooked()) {
                    System.out.println("Room Number: " + entry.getKey() + ", Room: " + entry.getValue().toString());
                }
            }
        }
        else {
            System.out.println("Hotel don't arrange rooms yet!");
        }
    }

    // Setters
    private void setHotelName(String hotelName) {
        if(hotelName.isBlank()) throw new RuntimeException("Hotel Name must not be empty or blank");
        this.hotelName = hotelName;
    }

    // Getters
    public String getHotelName() {
        return hotelName;
    }
}
