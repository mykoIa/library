package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.sukhorutchenko.library.entity.BookInformation;
import ua.sukhorutchenko.library.service.BookInformationService;

import java.util.List;

@RestController
@RequestMapping("/api/library/bookInfo")
public class BookInformationController {

    private final BookInformationService bookInformationService;

    public BookInformationController(BookInformationService bookInformationService) {
        this.bookInformationService = bookInformationService;
    }

    @GetMapping("/get")
    public List<BookInformation> showAllUser() {
        return bookInformationService.findAllBookInformation();
    }

    @GetMapping("/get/{id}")
    public BookInformation findAuthorById(@PathVariable("id") Long id) {
        return bookInformationService.findBookInformationById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable("id") Long id) {
        bookInformationService.deleteBookInformationById(id);
    }

    @GetMapping("/add/{genre}&{numberOfPages}")
    public void addAuthor(@PathVariable("genre") String genre,
                          @PathVariable("numberOfPages") Long numberOfPages) {
        bookInformationService.addBookInformation(new BookInformation(genre, numberOfPages));
    }
}
