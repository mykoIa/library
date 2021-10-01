package ua.sukhorutchenko.library.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.sukhorutchenko.library.dto.PublisherDTO;
import ua.sukhorutchenko.library.entity.Publisher;
import ua.sukhorutchenko.library.mapper.PublisherMapper;
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

    @Mock
    private PublisherMapper publisherMapper;

    @Test
    void findAllPublisher() {
        List<Publisher> publishers = new ArrayList<>();
        publishers.add(new Publisher());
        publishers.add(new Publisher());
        publishers.add(new Publisher());

        List<PublisherDTO> publishersDTO = new ArrayList<>();
        publishersDTO.add(new PublisherDTO());
        publishersDTO.add(new PublisherDTO());
        publishersDTO.add(new PublisherDTO());

        when(publisherRepository.findAll()).thenReturn(publishers);
        when(publisherService.findAllPublisher()).thenReturn(publishersDTO);

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
        publisher.setId(1L);
        publisher.setPublisherName("Test Name");

        publisherService.addPublisher(publisherMapper.entityToDTO(publisher));
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
        PublisherDTO publisherById = new PublisherDTO();
        publisherById.setId(1L);
        publisherById.setPublisherName("Test Name");

        Mockito.when(publisherMapper.entityToDTO(publisher)).thenReturn(publisherById);
        when(publisherRepository.findById(1L)).thenReturn(Optional.of(publisher));

        publisherById = publisherService.findPublisherById(1L);
        publisherById.setPublisherName("Update Name");
        publisherService.updatePublisher(publisherById);

        Mockito.verify(publisherRepository, Mockito.times(1)).save(publisherMapper.dtoToEntity(publisherById));
    }
}