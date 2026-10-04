package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.example.model.Category;
import org.example.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Product product) {
        if(product.getId() == null) entityManager.persist(product);
        else entityManager.merge(product);
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Product.class, id));
    }

    public Optional<Product> findBySku(String sku) {
        return entityManager
                .createQuery("SELECT p FROM Product p WHERE p.sku = :sku",
                        Product.class)
                .setParameter("sku", sku)
                .getResultStream().findFirst();
    }

    public List<Product> findByCategory(String categoryName) {
        return entityManager
                .createQuery("SELECT DISTINCT p FROM Product p JOIN FETCH " +
                        "p.categories c WHERE c.name = :name", Product.class)
                .setParameter("name", categoryName)
                .getResultList();
    }

    public List<Product> search(String keyword,
                                BigDecimal minPrice, BigDecimal maxPrice,
                                String category) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product>  cq = cb.createQuery(Product.class);
        Root<Product> productRoot = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        if(keyword != null && !keyword.trim().isEmpty()) {
            predicates.add(cb.like(
                    cb.lower(productRoot.get("name")),
                    "%" + keyword.toLowerCase() + "%"));
        }
        if(minPrice != null && maxPrice != null) {
            predicates.add(cb.and(
                    cb.greaterThanOrEqualTo(productRoot.get("price"), minPrice),
                    cb.lessThanOrEqualTo(productRoot.get("price"), maxPrice)
            ));
        }
        if(category != null && !category.trim().isEmpty()) {
            Join<Product, Category> join = productRoot.join("categories", JoinType.INNER);
            predicates.add(cb.equal(join.get("name"), category));
        }

        cq.select(productRoot).where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }

    public List<Product> findLowStock(int threshold) {
        return entityManager
                .createQuery("SELECT p FROM Product p WHERE p.stock <= :threshold",
                        Product.class)
                .setParameter("threshold", threshold)
                .getResultList();
    }

    public long countAll() {
        return entityManager
                .createQuery("SELECT COUNT(p) FROM Product p",
                        Long.class)
                .getSingleResult();
    }

    public List<Product> findPage(int page, int size) {
        int offset = (page - 1) * size;

        return entityManager
                .createQuery("SELECT p FROM Product p",
                        Product.class)
                .setFirstResult(offset)
                .setMaxResults(size)
                .getResultList();
    }
}
