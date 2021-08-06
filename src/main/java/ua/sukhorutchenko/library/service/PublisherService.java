package ua.sukhorutchenko.library.service;

import org.springframework.stereotype.Service;
import ua.sukhorutchenko.library.entity.Publisher;
import ua.sukhorutchenko.library.repository.PublisherRepository;

import java.util.List;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> findAllPublisher() {
        return publisherRepository.findAll();
    }

    public Publisher addPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public void deletePublisherById(Long id) {
        publisherRepository.deleteById(id);
    }

    public Publisher findPublisherById(Long id) {
        return publisherRepository.findById(id).get();
    }
}
