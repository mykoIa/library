package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.sukhorutchenko.library.dto.BookDTO;
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

    @GetMapping("/get")
    public List<BookDTO> showAllBook() {
        return BookMapper.INSTANCE.toDTO(bookService.findAllBook());
    }

    @GetMapping("/get/{id}")
    public BookDTO findBookById(@PathVariable("id") Long id) {
        return BookMapper.INSTANCE.toDTO(bookService.findBookById(id));
    }


    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
    }

    @RequestMapping("/add/{name}&{author_id}&{publisher_id}&{infoId}")
    public void addBook(@PathVariable("name") String name,
                        @PathVariable("author_id") Long authorId,
                        @PathVariable("publisher_id") Long publisherId,
                        @PathVariable("infoId") Long infoId) {
        bookService.addBook(new Book(name, authorService.findAuthorById(authorId),
                publisherService.findPublisherById(publisherId), bookInformationService.findBookInformationById(infoId)));
    }

    @RequestMapping("/update/{book_id}&{name}&{author_id}&{publisher_id}&{infoId}")
    public void updateBook(@PathVariable("book_id") Long bookId,
                           @PathVariable("name") String name,
                           @PathVariable("author_id") Long authorId,
                           @PathVariable("publisher_id") Long publisherId,
                           @PathVariable("infoId") Long infoId) {
        bookService.updateBook(bookService.findBookById(bookId), name,
                authorService.findAuthorById(authorId),
                publisherService.findPublisherById(publisherId),
                bookInformationService.findBookInformationById(infoId));
    }

}
