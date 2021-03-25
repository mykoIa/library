package ua.sukhorutchenko.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.sukhorutchenko.library.model.Book;
import ua.sukhorutchenko.library.model.User;
import ua.sukhorutchenko.library.service.BookService;
import ua.sukhorutchenko.library.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    private final UserService userService;
    private final BookService bookService;

    @Autowired
    public LibraryController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping("/user-create/{firstName}&{lastName}")
    public List<User> createUser(@PathVariable("firstName") String firstName,
                                 @PathVariable("lastName") String lastName) {
        userService.createUser(new User(firstName, lastName));
        return userService.findAllUsers();
    }

    @GetMapping("/show-all-users")
    public List<User> showAllUser() {
        return userService.findAllUsers();
    }


    @GetMapping("/delete-user/{id}")
    public List<User> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return userService.findAllUsers();
    }

    @GetMapping("/add-book/{author}&{name}")
    public List<Book> addBook(@PathVariable("author") String author,
                              @PathVariable("name") String name) {
        bookService.addBook(new Book(author, name));
        return bookService.findAllBook();
    }

    @GetMapping("/show-all-books")
    public List<Book> showAllBook() {
        return bookService.findAllBook();
    }


    @GetMapping("/delete-book/{id}")
    public List<Book> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
        return bookService.findAllBook();
    }

}
