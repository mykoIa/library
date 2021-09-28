package ua.sukhorutchenko.library.service.interf;

import ua.sukhorutchenko.library.dto.BookDTO;
import ua.sukhorutchenko.library.entity.Book;

import java.util.List;

public interface BookService {

    List<BookDTO> findAllBook();

    BookDTO findBookById(Long id);

    void addBook(BookDTO book);

    void deleteBookById(Long id);

    void updateBook(BookDTO book);

}
