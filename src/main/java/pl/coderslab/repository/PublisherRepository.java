package pl.coderslab.repository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Publisher;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Repository
public class PublisherRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public Publisher addPublisher(String name) {
        Publisher publisher = new Publisher();
        publisher.setName(name);
        entityManager.persist(publisher);
        return publisher;
    }
    public Publisher getPublisher(long id) {
        return entityManager.find(Publisher.class, id);
    }
    public Publisher updatePublisher(long id, String name) {
        Publisher publisher = entityManager.find(Publisher.class, id);
        publisher.setName(name);
        return entityManager.merge(publisher);
    }
    public Publisher deletePublisher(long id) {
        Publisher publisher = entityManager.find(Publisher.class, id);
        entityManager.remove(publisher);
        return publisher;
    }
}