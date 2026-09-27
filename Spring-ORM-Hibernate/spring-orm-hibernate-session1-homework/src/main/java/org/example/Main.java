package org.example;

import jakarta.persistence.Embeddable;
import org.example.entity.Employee;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction trx = session.beginTransaction();

        // Create emp1
        Employee emp1 = new Employee();
        emp1.setName("Nour");
        emp1.setDepartment("CS");
        emp1.setSalary(120000.00);
        session.persist(emp1);

        Employee emp2 = new Employee();
        emp2.setName("Nour");
        emp2.setDepartment("CS");
        emp2.setSalary(120000.00);
        session.persist(emp2);

        // Read Employee
        Employee found = session.get(Employee.class, emp1.getId());
        System.out.println(found.toString());

        //session.detach(emp1);

        System.out.println("emp1 == found: " + (emp1 == found));

        // Update Employee
        found.setSalary(2500000.00);
        System.out.println(found.toString());

        // Delete Employee emp2
        session.remove(emp2);

        trx.commit();
        session.close();
    }
}