package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.model.Order;
import org.example.model.OrderStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Order order) {
        if(order.getId() == null) entityManager.persist(order);
        else entityManager.merge(order);
    }

    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Order.class, id));
    }

    public Optional<Order> findByIdWithItems(Long id) {
        return entityManager
                .createQuery("SELECT DISTINCT o FROM Order o " +
                        "JOIN FETCH o.items i WHERE o.id = :id", Order.class)
                .setParameter("id", id)
                .getResultStream()
                .findFirst();
    }

    public List<Order> findByCustomer(Long customerId) {
        return entityManager
                .createQuery("SELECT o FROM Order o WHERE o.customer.id = :customerId",
                        Order.class)
                .setParameter("customerId", customerId)
                .getResultList();
    }

    public List<Order> findByStatus(OrderStatus status) {
        return entityManager
                .createQuery("SELECT o FROM Order o WHERE o.status = :status",
                        Order.class)
                .setParameter("status", status)
                .getResultList();
    }
}
