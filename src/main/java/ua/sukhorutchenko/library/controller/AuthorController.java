package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.sukhorutchenko.library.dto.AuthorDTO;
import ua.sukhorutchenko.library.entity.Author;
import ua.sukhorutchenko.library.mapper.AuthorMapper;
import ua.sukhorutchenko.library.service.AuthorServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/get")
    public List<AuthorDTO> showAllAuthor() {
        return AuthorMapper.INSTANCE.toDTO(authorService.findAllAuthor());
    }

    @GetMapping("/get/{id}")
    public AuthorDTO findAuthorById(@PathVariable("id") Long id) {
        return AuthorMapper.INSTANCE.toDTO(authorService.findAuthorById(id));
    }

    @RequestMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthorById(id);
    }

    @RequestMapping(value = "/add/{name}")
    public void addAuthor(@PathVariable("name") String name) {
        authorService.addAuthor(new Author(name));
    }

    @RequestMapping("/update/{id}&{name}")
    public void updateAuthor(@PathVariable("id") Long id,
                             @PathVariable("name") String name) {
        authorService.updateAuthor(authorService.findAuthorById(id), name);
    }
}

