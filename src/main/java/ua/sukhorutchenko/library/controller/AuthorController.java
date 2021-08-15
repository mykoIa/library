package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping("/getAll")
    public List<AuthorDTO> showAllAuthor() {
        return AuthorMapper.INSTANCE.toDTO(authorService.findAllAuthor());
    }

    @PostMapping("/getById")
    @ResponseBody
    public AuthorDTO findAuthorById(@RequestBody AuthorDTO author) {
        return AuthorMapper.INSTANCE.toDTO(authorService.findAuthorById(author.getId()));
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public void deleteAuthor(@RequestBody AuthorDTO author) {
        authorService.deleteAuthorById(author.getId());
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public void addAuthor(@RequestBody AuthorDTO author) {
        authorService.addAuthor(new Author(author.getFullName()));
    }

    @PutMapping("/update")
    @ResponseBody
    public void updateAuthor(@RequestBody AuthorDTO author) {
        authorService.updateAuthor(authorService.findAuthorById(author.getId()), author.getFullName());
    }
}
