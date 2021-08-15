package ua.sukhorutchenko.library.service.interf;

import ua.sukhorutchenko.library.entity.Publisher;

import java.util.List;

public interface PublisherService {

    List<Publisher> findAllPublisher();

    Publisher findPublisherById(Long id);

    Publisher addPublisher(Publisher publisher);

    void deletePublisherById(Long id);

    void updatePublisher(Publisher publisher, String name);

}
