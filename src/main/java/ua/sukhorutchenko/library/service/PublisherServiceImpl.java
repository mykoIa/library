package ua.sukhorutchenko.library.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    public List<Publisher> findAllPublisher() {
        return publisherRepository.findAll();
    }

    @Transactional
    public Publisher findPublisherById(Long id) {
        return publisherRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public Publisher addPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Transactional
    public void deletePublisherById(Long id) {
        publisherRepository.deleteById(id);
    }

    @Transactional
    public void updatePublisher(Publisher publisher, String name) {
        publisher.setPublisherName(name);
        publisherRepository.save(publisher);
    }

}
