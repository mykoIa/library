package ua.sukhorutchenko.library.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.sukhorutchenko.library.entity.Publisher;
import ua.sukhorutchenko.library.repository.PublisherRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PublisherServiceImplTest {

    @InjectMocks
    private PublisherServiceImpl publisherService;

    @Mock
    private PublisherRepository publisherRepository;

    @Test
    void findAllPublisher() {
        List<Publisher> publishers = new ArrayList<>();
        publishers.add(new Publisher());
        publishers.add(new Publisher());
        publishers.add(new Publisher());

        when(publisherRepository.findAll()).thenReturn(publishers);

        assertEquals(3, publisherService.findAllPublisher().size());
    }

    @Test
    void findPublisherById() {
        Publisher publisher = new Publisher();
        publisher.setId(1L);
        publisher.setPublisherName("Test Name");

        when(publisherRepository.findById(1L)).thenReturn(Optional.of(publisher));

        assertEquals(publisher.getPublisherName(), publisherRepository.findById(1L).orElseThrow(NoSuchElementException::new).getPublisherName());
    }

    @Test
    void addPublisher() {
        Publisher publisher = new Publisher();
        publisherService.addPublisher(publisher);

        Mockito.verify(publisherRepository, Mockito.times(1)).save(publisher);
    }

    @Test
    void deletePublisherById() {
        Publisher publisher = new Publisher();
        publisher.setId(1L);
        publisher.setPublisherName("Test Name");

        publisherService.deletePublisherById(1L);

        Mockito.verify(publisherRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    void updatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setId(1L);
        publisher.setPublisherName("Test Name");

        when(publisherRepository.findById(1L)).thenReturn(Optional.of(publisher));

        Publisher authorById = publisherService.findPublisherById(1L);
        authorById.setPublisherName("Update Name");
        publisherService.updatePublisher(authorById, "Test Name");

        Mockito.verify(publisherRepository, Mockito.times(1)).save(authorById);
    }
}