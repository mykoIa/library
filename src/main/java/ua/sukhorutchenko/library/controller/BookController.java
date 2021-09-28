package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.*;
import ua.sukhorutchenko.library.dto.BookDTO;
import ua.sukhorutchenko.library.mapper.BookMapper;
import ua.sukhorutchenko.library.service.BookServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getAll")
    public List<BookDTO> showAllBook() {
        return bookService.findAllBook();
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public BookDTO findBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public void addBook(@RequestBody BookDTO book) {
        bookService.addBook(book);
    }

    @PutMapping("/update")
    @ResponseBody
    public void updateBook(@RequestBody BookDTO book) {
        bookService.updateBook(book);
    }

}
