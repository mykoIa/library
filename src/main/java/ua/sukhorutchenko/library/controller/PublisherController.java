package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.sukhorutchenko.library.dto.PublisherDTO;
import ua.sukhorutchenko.library.entity.Publisher;
import ua.sukhorutchenko.library.mapper.PublisherMapper;
import ua.sukhorutchenko.library.service.PublisherServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherServiceImpl publisherService;

    public PublisherController(PublisherServiceImpl publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/get")
    public List<PublisherDTO> showAllPublisher() {
        return PublisherMapper.INSTANCE.toDTO(publisherService.findAllPublisher());
    }

    @GetMapping("/get/{id}")
    public PublisherDTO findPublisherById(@PathVariable("id") Long id) {
        return PublisherMapper.INSTANCE.toDTO(publisherService.findPublisherById(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deletePublisher(@PathVariable("id") Long id) {
        publisherService.deletePublisherById(id);
    }

    @GetMapping("/add/{name}")
    public void addPublisher(@PathVariable("name") String name) {
        publisherService.addPublisher(new Publisher(name));
    }

    @RequestMapping("/update/{id}&{name}")
    public void updatePublisher(@PathVariable("id") Long id,
                                @PathVariable("name") String name) {
        publisherService.updatePublisher(publisherService.findPublisherById(id), name);
    }
}

