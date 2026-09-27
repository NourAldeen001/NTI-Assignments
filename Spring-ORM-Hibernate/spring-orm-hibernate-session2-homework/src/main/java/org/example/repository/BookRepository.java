package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.example.models.Author;
import org.example.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private final EntityManager entityManager;

    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Book book) {
        entityManager.persist(book);
    }

    /// JPQL -> Hibernate parse it using its HQL engine
    /// JPQL is standardized by JPA and works with any JPA Provider
    public List<Book> findAllBooksByAuthorName(String authorName) {
        TypedQuery<Book> query = entityManager.createQuery(
                "SELECT b FROM Book b JOIN b.author a WHERE a.name = :authorName", Book.class);
        // SELECT b FROM Book b WHERE b.author.name = :authorName
        query.setParameter("authorName", authorName);
        return query.getResultList();
    }

    /// HQL is a superset of JPQL
    /// HQL extends JPQL and offers Hibernate-specific features
    public List<Book> findAllBooksByAuthorNameWithHQL(String authorName) {
        TypedQuery<Book> query = entityManager.createQuery(
                "FROM Book b JOIN b.author a WITH a.name = :authorName", Book.class);
        // FROM Book b JOIN b.author a WITH a.name = :authorName
        query.setParameter("authorName", authorName);
        return query.getResultList();
    }

    public List<Book> findAllBooksByPublisherName(String publisherName) {
        return entityManager.createQuery(
                        "SELECT b FROM Book b WHERE b.publisher.name = :pubName", Book.class)
                .setParameter("pubName", publisherName)
                .getResultList();
    }

    public Book findBookById(Long id) {
        return entityManager.createQuery(
                "SELECT b FROM Book b WHERE b.id = ?1", Book.class)
        .setParameter(1, id)
        .getSingleResult();

        //return entityManager.find(Book.class, 1L);
    }

    public List<Book> findBooksByTitle(String bookTitle) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);

        Root<Book> root = cq.from(Book.class);
        cq.select(root).where(cb.equal(root.get("title"), bookTitle));

        return entityManager.createQuery(cq).getResultList();
    }

    public List<Book> findBookByTitleOrAuthorName(String bookTitle, String authorName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);

        Root<Book> book = cq.from(Book.class);

        List<Predicate> predicates = new ArrayList<>();

        if(bookTitle != null && !bookTitle.trim().isEmpty()) {
            predicates.add(cb.like(book.get("title"), "%" + bookTitle + "%"));
        }

        if(authorName != null && !authorName.trim().isEmpty()) {
            Join<Book, Author> join = book.join("author", JoinType.INNER);
            predicates.add(cb.like(join.get("name"), "%" + authorName + "%"));
        }

        cq.select(book).where(cb.or(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(cq).getResultList();
    }

}
