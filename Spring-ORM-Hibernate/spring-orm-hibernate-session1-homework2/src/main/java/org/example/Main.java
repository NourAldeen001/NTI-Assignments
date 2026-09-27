package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.model.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        try(EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("empPU")) {

            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            Employee employee1 = new Employee();
            Employee employee2 = new Employee();
            System.out.println("Transient State");

            employee1.setName("Mohamed");
            employee1.setDepartment("IT");
            employee1.setSalary(120000.50);

            employee2.setName("Nour");
            employee2.setDepartment("IS");
            employee2.setSalary(200000.50);

            System.out.println("Save()");
            entityManager.persist(employee1);
            entityManager.persist(employee2);


            System.out.println("Managed State");

            //entityManager.getTransaction().commit();

            //entityManager.getTransaction().begin();

            //entityManager.detach(employee1);

            System.out.println("FindById()");
            Employee found = entityManager.find(Employee.class, employee1.getId());
            System.out.println("employee1 == found: " + (employee1 == found));


            System.out.println("FindAll()");
            List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
            employees.forEach(e -> System.out.println(e.toString()));

            System.out.println("Update salary");
            employee1.setSalary(190000);

            System.out.println("Delete()");
            entityManager.remove(employee2);

            System.out.println("FindAll()");
            List<Employee> employeesAfterDelete = entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
            employeesAfterDelete.forEach(e -> System.out.println(e.toString()));

            entityManager.getTransaction().commit();

        }
//        entityManager.close();
//        entityManagerFactory.close();
    }
}