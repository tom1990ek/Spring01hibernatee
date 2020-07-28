package pl.coderslab.service;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Author;
import pl.coderslab.repository.AuthorRepository;
import javax.transaction.Transactional;
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Transactional
    public Author addAuthor(String firstName, String lastName) {
        return authorRepository.addAuthor(firstName, lastName);
    }
    @Transactional
    public Author findAuthorById(long id) {
        return authorRepository.findAuthorById(id);
    }
    @Transactional
    public Author updateAuthor(long id, String firstName, String lastName) {
        return authorRepository.updateAuthor(id, firstName, lastName);
    }
    @Transactional
    public Author deleteAuthor(long id) {
        return authorRepository.deleteAuthor(id);
    }
}