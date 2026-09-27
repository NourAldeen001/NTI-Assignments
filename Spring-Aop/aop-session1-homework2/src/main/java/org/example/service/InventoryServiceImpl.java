package org.example.service;

public class InventoryServiceImpl implements InventoryService {

    @Override
    public int checkStock(String sku) {
        System.out.println("Checking stock....");
        return 5;
    }

    @Override
    public void reserveStock(String sku, int qty) throws IllegalStateException {
        System.out.println("Reserving stock....");
        if(qty > 100) {
            throw new IllegalStateException("Quantity cannot be exceed 100");
        }

    }
}
