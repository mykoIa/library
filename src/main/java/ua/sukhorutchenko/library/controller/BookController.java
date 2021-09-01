package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.sukhorutchenko.library.dto.BookDTO;
import ua.sukhorutchenko.library.entity.Author;
import ua.sukhorutchenko.library.entity.Book;
import ua.sukhorutchenko.library.mapper.BookMapper;
import ua.sukhorutchenko.library.service.AuthorServiceImpl;
import ua.sukhorutchenko.library.service.BookInformationServiceImpl;
import ua.sukhorutchenko.library.service.BookServiceImpl;
import ua.sukhorutchenko.library.service.PublisherServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookServiceImpl bookService;
    private final AuthorServiceImpl authorService;
    private final PublisherServiceImpl publisherService;
    private final BookInformationServiceImpl bookInformationService;

    public BookController(BookServiceImpl bookService, AuthorServiceImpl authorService, PublisherServiceImpl publisherService, BookInformationServiceImpl bookInformationService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.bookInformationService = bookInformationService;
    }

    @GetMapping("/getAll")
    public List<BookDTO> showAllBook() {
        return BookMapper.INSTANCE.toDTO(bookService.findAllBook());
    }

    @PostMapping("/getById")
    @ResponseBody
    public BookDTO findBookById(@RequestBody BookDTO book) {
        return BookMapper.INSTANCE.toDTO(bookService.findBookById(book.getId()));
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public void deleteBook(@RequestBody BookDTO book) {
        bookService.deleteBookById(book.getId());
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public void addBook(@RequestBody BookDTO book) {
        bookService.addBook(new Book(book.getName(),
                authorService.findAuthorsById((List<Author>) book.getAuthor()),
                publisherService.findPublisherById(book.getPublisher().getId()),
                bookInformationService.findBookInformationById(book.getBookInformation().getId())));
    }

    @PutMapping("/update")
    @ResponseBody
    public void updateBook(@RequestBody BookDTO book) {
        bookService.updateBook(bookService.findBookById(book.getId()), book.getName(),
                authorService.findAuthorById(book.getAuthor().getId()),
                publisherService.findPublisherById(book.getPublisher().getId()),
                bookInformationService.findBookInformationById(book.getBookInformation().getId()));
    }

}
