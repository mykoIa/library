package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.sukhorutchenko.library.entity.Publisher;
import ua.sukhorutchenko.library.service.PublisherService;

import java.util.List;

@RestController
@RequestMapping("/api/library/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/get")
    public List<Publisher> showAllUser() {
        return publisherService.findAllPublisher();
    }

    @GetMapping("/get/{id}")
    public Publisher findAuthorById(@PathVariable("id") Long id) {
        return publisherService.findPublisherById(id);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable("id") Long id) {
        publisherService.deletePublisherById(id);
    }

    @GetMapping("/add/{name}")
    public void addAuthor(@PathVariable("name") String name) {
        publisherService.addPublisher(new Publisher(name));
    }
}

