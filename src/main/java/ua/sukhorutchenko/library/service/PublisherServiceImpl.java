package ua.sukhorutchenko.library.service;

import org.springframework.stereotype.Service;
import ua.sukhorutchenko.library.entity.Publisher;
import ua.sukhorutchenko.library.repository.PublisherRepository;
import ua.sukhorutchenko.library.service.interf.PublisherService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> findAllPublisher() {
        return publisherRepository.findAll();
    }

    public Publisher findPublisherById(Long id) {
        return publisherRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Publisher addPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public void deletePublisherById(Long id) {
        publisherRepository.deleteById(id);
    }

    public void updatePublisher(Publisher publisher, String name) {
        publisher.setPublisherName(name);
        publisherRepository.save(publisher);
    }

}
