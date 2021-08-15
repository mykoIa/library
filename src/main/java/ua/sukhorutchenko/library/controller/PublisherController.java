package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping("/getAll")
    public List<PublisherDTO> showAllPublisher() {
        return PublisherMapper.INSTANCE.toDTO(publisherService.findAllPublisher());
    }

    @PostMapping("/getById")
    @ResponseBody
    public PublisherDTO findPublisherById(@RequestBody PublisherDTO publisher) {
        return PublisherMapper.INSTANCE.toDTO(publisherService.findPublisherById(publisher.getId()));
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public void deletePublisher(@RequestBody PublisherDTO publisher) {
        publisherService.deletePublisherById(publisher.getId());
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public void addPublisher(@RequestBody PublisherDTO publisher) {
        publisherService.addPublisher(new Publisher(publisher.getPublisherName()));
    }

    @PutMapping("/update")
    @ResponseBody
    public void updatePublisher(@RequestBody PublisherDTO publisher) {
        publisherService.updatePublisher(publisherService.findPublisherById(publisher.getId()), publisher.getPublisherName());
    }

}

