package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.dto.CategoryRevenue;
import org.example.dto.CustomerSpend;
import org.example.dto.MonthlySales;
import org.example.model.OrderStatus;
import org.example.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<CategoryRevenue> revenueByCategory(String categoryName) {
        return entityManager
                .createQuery("""
                        SELECT new org.example.dto.CategoryRevenue(
                            c.name,
                            SUM(i.quantity * i.unitPrice)
                        )
                        FROM Order o
                        JOIN o.items i
                        JOIN i.product p
                        JOIN p.categories c
                        WHERE o.status IN (
                            org.example.model.OrderStatus.PAID,
                            org.example.model.OrderStatus.SHIPPED
                        )
                        GROUP BY c.name
                        ORDER BY SUM(i.quantity * i.unitPrice) DESC
                        """, CategoryRevenue.class)
                .getResultList();

    }

    public List<CustomerSpend> topCustomers(int limit) {
        return entityManager
                .createQuery("""
                        SELECT new org.example.dto.CustomerSpend(
                            c.name,
                            SUM(i.quantity * i.unitPrice)
                        )
                        FROM Customer c
                        JOIN c.orders o
                        JOIN o.items i
                        GROUP BY c.id, c.name
                        ORDER BY SUM(i.quantity * i.unitPrice) DESC
                        """, CustomerSpend.class)
                .setMaxResults(limit)
                .getResultList();
    }

    public Map<OrderStatus, Long> ordersPerStatus() {
        List<Object[]> results = entityManager
                .createQuery("""
                        SELECT o.status, COUNT(o)
                        FROM Order o
                        GROUP BY o.status
                        """, Object[].class)
                .getResultList();

        Map<OrderStatus, Long> map = new EnumMap<>(OrderStatus.class);
        for(Object[] row : results) {
            map.put((OrderStatus) row[0], (Long) row[1]);
        }
        return map;
    }

    public List<Product> productsNeverOrdered() {
        // I perfer this solution because cost of join
        return entityManager
                .createQuery("""
                        SELECT p
                        FROM Product p
                        WHERE NOT EXISTS (
                            SELECT i
                            FROM OrderItem i
                            WHERE i.product = p
                        )
                        """, Product.class)
                .getResultList();

//        return entityManager
//                .createQuery("""
//                        SELECT DISTINCT p
//                        FROM Product p
//                        LEFT JOIN p.items i
//                            ON i.product = p
//                        WHERE i.id IS NULL
//                        """, Product.class)
//                .getResultList();
    }

    public List<MonthlySales> monthlySales(int year) {
        return entityManager
                .createQuery("""
                        SELECT new org.example.dto.MonthlySales(
                            MONTH(o.orderedAt),
                            SUM(i.quantity * i.unitPrice)
                        )
                        FROM Order o
                        JOIN o.items i
                        WHERE YEAR(o.orderedAt) = :year
                            AND o.status IN (
                               org.example.model.OrderStatus.PAID,
                               org.example.model.OrderStatus.SHIPPED
                            )
                        GROUP BY MONTH(o.orderedAt)
                        ORDER BY MONTH(o.orderedAt)
                        """, MonthlySales.class)
                .setParameter("year", year)
                .getResultList();
    }

    @Transactional
    public void applyDiscount(String category, int percent) {
        entityManager
                .createQuery("""
                        UPDATE Product p
                        SET p.price = p.price * (100 - :discount) / 100.0
                        WHERE EXISTS (
                            SELECT c
                            FROM p.categories c
                            WHERE c.name = :category
                        )
                        """)
                .setParameter("discount", percent)
                .setParameter("category", category)
                .executeUpdate();

        entityManager.clear();


         /// Bulk JPQL (Update and Delete) queries modify data directly in ""db""
        /// and ""persistence context"" doesn't have any information about this query
        /// that leave db and persistence context without sync -> (problem show here)
        /// to solve it -> called ""entityManager.clear()"" to clear persistence context
        /// and force future queries to load fresh data from db.

        /// That is why the next section announces
        /// ""@Modifying(clearAutomatically = true) annotation"".
        /// That's make why we do it manually by hands in this section.

    }
}
