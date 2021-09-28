package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/getAll")
    public List<PublisherDTO> showAllPublisher() {
        return publisherService.findAllPublisher();
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public PublisherDTO findPublisherById(@PathVariable Long id) {
        return publisherService.findPublisherById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisherById(id);
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public void addPublisher(@RequestBody PublisherDTO publisher) {
        publisherService.addPublisher(publisher);
    }

    @PutMapping("/update")
    @ResponseBody
    public void updatePublisher(@RequestBody PublisherDTO publisher) {
        publisherService.updatePublisher(publisher);
    }

}

