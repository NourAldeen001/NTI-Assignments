package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.models.Author;
import org.example.models.Book;
import org.example.models.Category;
import org.example.models.Publisher;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        try(EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("persistenceUnit")) {
            try(EntityManager em = emf.createEntityManager()) {

                em.getTransaction().begin();

                // Transient
                Publisher publisher1 = new Publisher();
                Publisher publisher2 = new Publisher();

                publisher1.setName("Wiley");
                publisher2.setName("Mc-Graw");

                // Managed
                em.persist(publisher1);
                em.persist(publisher2);

                // Transient
                Author author1 = new Author();
                Author author2 = new Author();
                Author author3 = new Author();

                author1.setName("H.P");
                author1.setNationality("British");

                author2.setName("Kin");
                author2.setNationality("American");

                author3.setName("Uncle Bob");
                author3.setNationality("American");

                // Managed
                em.persist(author1);
                em.persist(author2);
                em.persist(author3);

                // Transient
                Category category1 = new Category();
                Category category2 = new Category();

                category1.setName("Adventuring");
                category2.setName("Programming");

                em.persist(category1);
                em.persist(category2);

                // Transient
                Book book1 = new Book();
                Book book2 = new Book();
                Book book3 = new Book();
                Book book4 = new Book();

                book1.setTitle("Harry Potar Part1");
                book1.setIsbn(1511891L);
                book1.setPages(500L);
                book1.addCategory(category1);
                book1.setAuthor(author1);
                book1.setPublisher(publisher1);

                book2.setTitle("Harry Potar Part2");
                book2.setIsbn(1511541L);
                book2.setPages(700L);
                book2.addCategory(category1);
                book2.setAuthor(author1);
                book2.setPublisher(publisher1);

                book3.setTitle("Grokking Algorithm");
                book3.setIsbn(1511456L);
                book3.setPages(256L);
                book3.addCategory(category2);
                book3.setAuthor(author2);
                book3.setPublisher(publisher1);

                book4.setTitle("Clean Code");
                book4.setIsbn(1511851L);
                book4.setPages(324L);
                book4.addCategory(category2);
                book4.setAuthor(author3);
                book4.setPublisher(publisher2);

                // Managed
                em.persist(book1);
                em.persist(book2);
                em.persist(book3);
                em.persist(book4);


                BookRepository bookRepository = new BookRepository(em);
                AuthorRepository authorRepository = new AuthorRepository(em);


                /// Find all books by a given author's name using JPQL
                System.out.println("Find all books by a given author's name using JPQL");
                List<Book> booksWithAuthor = bookRepository.findAllBooksByAuthorName("Uncle Bob");
                booksWithAuthor.forEach(System.out::println);

                /// Find all books belonging to a given publisher
                System.out.println("Find all books belonging to a given publisher");
                List<Book> booksWithPublisher = bookRepository.findAllBooksByPublisherName("Wiley");
                booksWithPublisher.forEach(System.out::println);

                /// Find a specific Book by id using a positional parameter
                System.out.println("Find a specific Book by id using a positional parameter");
                Book bookById = bookRepository.findBookById(1L);
                System.out.println(bookById);


                /// Fetch an Author together with all of their Books using JOIN FETCH
                System.out.println("Fetch an Author together with all of their Books using JOIN FETCH");
                Author authorWithBooks = authorRepository.findAuthorWithBooksById(1L);
                System.out.println(authorWithBooks);
                authorWithBooks.getBooks().forEach(System.out::println);


                /** Write an aggregate query that returns each author's name
                 * and the number of books they have using COUNT and GROUP BY
                 */
                System.out.println("Write an aggregate query that returns each author's name \n" +
                        "and the number of books they have using COUNT and GROUP BY");
                List<Object[]> authorWithBooksNum = authorRepository.findAuthorWithBooksNum(1L);
                authorWithBooksNum.forEach(row -> {
                    String authorName = (String) row[0];
                    Long bookCount = (Long) row[1];
                    System.out.println("Author Name: " + authorName + ", Books written: " + bookCount);
               });

                /// Create a Criteria API query that finds books by title
                System.out.println("Create a Criteria API query that finds books by title");
                List<Book> booksWithTitle = bookRepository.findBooksByTitle("Grokking Algorithm");
                booksWithTitle.forEach(System.out::println);

                /**
                 * Extend the Criteria API query so that the title
                 *   and author-name filters are optional and predicates are added dynamically
                 */
                System.out.println("Extend the Criteria API query so that the title \n" +
                        "and author-name filters are optional and predicates are added dynamically");
                List<Book> re = bookRepository.findBookByTitleOrAuthorName("Harry", "Uncle Bob");
                re.forEach(System.out::println);


                /**
                 * "Compare a normal LAZY query with the JOIN FETCH version and explain \n" +
                 * " why JOIN FETCH can prevent LazyInitializationException for that use case"
                 */
                System.out.println("Compare a normal LAZY query with the JOIN FETCH version and explain \n" +
                        " why JOIN FETCH can prevent LazyInitializationException for that use case");

                // With Join Fetch
                Author authorWithBooksTest = authorRepository.findAuthorWithBooksById(1L);
                System.out.println(authorWithBooksTest);
                em.detach(authorWithBooksTest);
                System.out.println(authorWithBooksTest.getBooks().size());

                // Without Join Fetch
                Author authorWithBooksTest2 = authorRepository.findAuthorWithBooksByIdWithoutJOINFetch(1L);
                System.out.println(authorWithBooksTest2);
                //em.detach(authorWithBooksTest2); /// Throw LazyInitializationException
                System.out.println(authorWithBooksTest2.getBooks().size());


                /// Write one query using standard JPQL and explain how a Hibernate-specific HQL feature would differ
                System.out.println("Write one query using standard JPQL and \n" +
                        "explain how a Hibernate-specific HQL feature would differ");
                List<Book> booksByAuthorNameWithHQL = bookRepository.findAllBooksByAuthorNameWithHQL("H.P");
                booksByAuthorNameWithHQL.forEach(System.out::println);



                em.getTransaction().commit();
            }
        }
    }
}