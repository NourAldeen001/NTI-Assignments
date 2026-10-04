package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Customer customer) {
        if(customer.getId() == null) entityManager.persist(customer);
        else entityManager.merge(customer);
    }

    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Customer.class, id));
    }

    public Optional<Customer> findByEmail(String email) {
        return entityManager
                .createQuery("SELECT c FROM Customer c WHERE c.email = :email",
                        Customer.class)
                .setParameter("email", email)
                .getResultStream().findFirst();
    }

    public List<Customer> findAll() {
        return entityManager
                .createQuery("SELECT c FROM Customer c", Customer.class)
                .getResultList();
    }

}
