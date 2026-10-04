package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.model.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class CategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Category category) {
        if(category.getId() == null) entityManager.persist(category);
        else entityManager.merge(category);
    }

    public Optional<Category> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Category.class, id));
    }

    public Optional<Category> findByName(String categoryName) {
        return entityManager
                .createQuery("SELECT c FROM Category c WHERE c.name = :name",
                        Category.class)
                .setParameter("name", categoryName)
                .getResultStream()
                .findFirst();
    }
}
