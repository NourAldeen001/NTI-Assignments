package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Employee;

public class EmployeeDao {

    private final EntityManager entityManager;

    public EmployeeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }
}
