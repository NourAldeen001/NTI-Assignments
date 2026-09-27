package org.example.service;

import org.example.exception.CustomerNotFoundException;
import org.example.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

    private Long autoId = 1L;

    private List<Customer> customers = new ArrayList<>();

    public Customer save(Customer customer) {
        if(customer != null) {
            System.out.println("id: " + autoId);
            customer.setId(autoId);
            customers.add(customer);
            autoId++;
        }
        return customer;
    }

    public Customer findById(Long id) {
        return customers.stream().filter(cus -> Objects.equals(cus.getId(), id)).findFirst()
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public List<Customer> findAll() {
        return customers;
    }
}
