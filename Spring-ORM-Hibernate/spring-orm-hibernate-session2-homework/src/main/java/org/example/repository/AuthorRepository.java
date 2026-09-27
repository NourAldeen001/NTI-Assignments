package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.models.Author;

import java.util.List;

public class AuthorRepository {

    private final EntityManager entityManager;

    public AuthorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Author author) {
        entityManager.persist(author);
    }

    public Author findAuthorWithBooksById(Long id) {
        return entityManager.createQuery("SELECT auth FROM Author auth " +
                        "JOIN FETCH auth.books WHERE auth.id = :id", Author.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public Author findAuthorWithBooksByIdWithoutJOINFetch(Long id) {
        return entityManager.createQuery("SELECT auth FROM Author auth " +
                        "JOIN auth.books b WHERE auth.id = :id", Author.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<Object[]> findAuthorWithBooksNum(Long id) {
        return entityManager.createQuery(
                        "SELECT a.name, COUNT(b) FROM Author a JOIN a.books b GROUP BY a.name", Object[].class)
                .getResultList();

    }

}
