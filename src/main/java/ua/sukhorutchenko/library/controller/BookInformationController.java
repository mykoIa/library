package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.sukhorutchenko.library.entity.BookInformation;
import ua.sukhorutchenko.library.service.BookInformationServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/bookInfo")
public class BookInformationController {

    private final BookInformationServiceImpl bookInformationService;

    public BookInformationController(BookInformationServiceImpl bookInformationService) {
        this.bookInformationService = bookInformationService;
    }

    @GetMapping("/get")
    public List<BookInformation> showAllBookInfo() {
        return bookInformationService.findAllBookInformation();
    }

    @GetMapping("/get/{id}")
    public BookInformation findBookInfoById(@PathVariable("id") Long id) {
        return bookInformationService.findBookInformationById(id);
    }

    @RequestMapping("/delete/{id}")
    public void deleteBookInfo(@PathVariable("id") Long id) {
        bookInformationService.deleteBookInformationById(id);
    }

    @GetMapping("/add/{genre}&{numberOfPages}")
    public void addBookInfo(@PathVariable("genre") String genre,
                            @PathVariable("numberOfPages") Long numberOfPages) {
        bookInformationService.addBookInformation(new BookInformation(genre, numberOfPages));
    }

    @RequestMapping("/update/{id}&{genre}&{numberOfPages}")
    public void updateBookInfo(@PathVariable("id") Long id,
                               @PathVariable("genre") String genre,
                               @PathVariable("numberOfPages") Long numberOfPages) {
        bookInformationService.updateBookInformation(bookInformationService.findBookInformationById(id), genre, numberOfPages);
    }
}
