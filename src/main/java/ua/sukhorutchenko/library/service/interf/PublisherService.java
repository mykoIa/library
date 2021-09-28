package ua.sukhorutchenko.library.service.interf;

import ua.sukhorutchenko.library.dto.PublisherDTO;

import java.util.List;

public interface PublisherService {

    List<PublisherDTO> findAllPublisher();

    PublisherDTO findPublisherById(Long id);

    void addPublisher(PublisherDTO publisher);

    void deletePublisherById(Long id);

    void updatePublisher(PublisherDTO publisher);

}
