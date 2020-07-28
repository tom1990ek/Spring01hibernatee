package pl.coderslab.service;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.PublisherRepository;
import javax.transaction.Transactional;
@Service
public class PublisherService {
    private PublisherRepository publisherRepository;
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }
    @Transactional
    public Publisher addPublisher(String name) {
        return publisherRepository.addPublisher(name);
    }
    @Transactional
    public Publisher getPublisher(long id) {
        return publisherRepository.getPublisher(id);
    }
    @Transactional
    public Publisher updatePublisher(long id, String name) {
        return publisherRepository.updatePublisher(id, name);
    }
    @Transactional
    public Publisher deletePublisher(long id) {
        return publisherRepository.deletePublisher(id);
    }
}