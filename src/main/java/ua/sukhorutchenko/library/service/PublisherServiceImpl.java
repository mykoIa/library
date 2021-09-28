package ua.sukhorutchenko.library.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.sukhorutchenko.library.dto.PublisherDTO;
import ua.sukhorutchenko.library.mapper.PublisherMapper;
import ua.sukhorutchenko.library.repository.PublisherRepository;
import ua.sukhorutchenko.library.service.interf.PublisherService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    public PublisherServiceImpl(PublisherRepository publisherRepository, PublisherMapper publisherMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherMapper = publisherMapper;
    }

    @Transactional
    public List<PublisherDTO> findAllPublisher() {
        return publisherMapper.entityToDTO(publisherRepository.findAll());
    }

    @Transactional
    public PublisherDTO findPublisherById(Long id) {
        return publisherMapper.entityToDTO(publisherRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Transactional
    public void addPublisher(PublisherDTO publisher) {
        publisherRepository.save(publisherMapper.dtoToEntity(publisher));
    }

    @Transactional
    public void deletePublisherById(Long id) {
        publisherRepository.deleteById(id);
    }

    @Transactional
    public void updatePublisher(PublisherDTO publisherDTO) {
        PublisherDTO publisher = findPublisherById(publisherDTO.getId());
        publisher.setPublisherName(publisherDTO.getPublisherName());
        publisherRepository.save(publisherMapper.dtoToEntity(publisher));
    }

}
