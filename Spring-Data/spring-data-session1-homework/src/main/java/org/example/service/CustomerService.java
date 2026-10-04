package org.example.service;

import org.example.dto.RegisterRequest;
import org.example.exception.DuplicateCustomerException;
import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void register(RegisterRequest request) {
        customerRepository.findByEmail(request.email())
                .ifPresent(customer -> {
                    throw new DuplicateCustomerException(request.email());
                });

        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setShippingAddress(request.address());

        customerRepository.save(customer);
    }
}
