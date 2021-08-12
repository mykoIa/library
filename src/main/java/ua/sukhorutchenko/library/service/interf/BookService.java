package ua.sukhorutchenko.library.service.interf;

import org.springframework.stereotype.Service;
import ua.sukhorutchenko.library.entity.Author;
import ua.sukhorutchenko.library.entity.Book;
import ua.sukhorutchenko.library.entity.BookInformation;
import ua.sukhorutchenko.library.entity.Publisher;

import java.util.List;

@Service
public interface BookService {

    List<Book> findAllBook();

    Book findBookById(Long id);

    Book addBook(Book book);

    void deleteBookById(Long id);

    void updateBook(Book book, String name, Author author, Publisher publisher, BookInformation bookInformation);
}
