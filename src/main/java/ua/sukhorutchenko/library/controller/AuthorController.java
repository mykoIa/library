package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.*;
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
        return authorService.findAllAuthor();
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public AuthorDTO findAuthorById(@PathVariable Long id) {
        return authorService.findAuthorById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthorById(id);
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public void addAuthor(@RequestBody AuthorDTO author) {
        authorService.addAuthor(author);
    }

    @PutMapping("/update")
    @ResponseBody
    public void updateAuthor(@RequestBody AuthorDTO author) {
        authorService.updateAuthor(author);
    }

}
