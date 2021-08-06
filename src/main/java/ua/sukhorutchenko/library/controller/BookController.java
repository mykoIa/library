package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.sukhorutchenko.library.entity.Book;
import ua.sukhorutchenko.library.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/library/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/get")
    public List<Book> showAllBook() {
        return bookService.findAllBook();
    }

    @GetMapping("/get/{id}")
    public Book findUserById(@PathVariable("id") Long id) {
        return bookService.findBookById(id);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
    }

    @RequestMapping("/add/{name}&{author_id}")
    public void addBook(@PathVariable("name") String name,
                        @PathVariable("author_id") Long authorId) {
        bookService.addBook(new Book(name, authorId));
    }

}
