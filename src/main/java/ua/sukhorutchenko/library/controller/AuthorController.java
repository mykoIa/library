package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.sukhorutchenko.library.entity.Author;
import ua.sukhorutchenko.library.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/api/library/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/get")
    public List<Author> showAllAuthor() {
        return authorService.findAllAuthor();
    }

    @GetMapping("/get/{id}")
    public Author findAuthorById(@PathVariable("id") Long id) {
        return authorService.findAuthorById(id);
    }

    @RequestMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthorById(id);
    }

    @RequestMapping(value = "/add/{name}")
    public Author addAuthor(@PathVariable("name") String name) {
        return authorService.addAuthor(new Author(name));
    }

    @RequestMapping("/update/{id}&{name}")
    public void updateAuthor(@PathVariable("id") Long id,
                             @PathVariable("name") String name) {
        authorService.updateAuthor(authorService.findAuthorById(id), name);
    }
}
