package ua.sukhorutchenko.library.service.interf;

import org.springframework.stereotype.Service;
import ua.sukhorutchenko.library.entity.Publisher;

import java.util.List;

@Service
public interface PublisherService {

    List<Publisher> findAllPublisher();

    Publisher findPublisherById(Long id);

    Publisher addPublisher(Publisher publisher);

    void deletePublisherById(Long id);

    void updatePublisher(Publisher publisher, String name);
}
