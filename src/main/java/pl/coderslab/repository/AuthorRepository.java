package pl.coderslab.repository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Repository
public class AuthorRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public Author addAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        entityManager.persist(author);
        return author;
    }
    public Author findAuthorById(long id) {
        return entityManager.find(Author.class, id);
    }
    public Author updateAuthor(long id, String firstName, String lastName) {
        Author author = entityManager.find(Author.class, id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        entityManager.merge(author);
        return author;
    }
    public Author deleteAuthor(long id) {
        Author author = entityManager.find(Author.class, id);
        entityManager.remove(author);
        return author;
    }
}