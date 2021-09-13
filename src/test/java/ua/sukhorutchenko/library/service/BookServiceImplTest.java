package ua.sukhorutchenko.library.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.sukhorutchenko.library.dto.BookDTO;
import ua.sukhorutchenko.library.entity.Book;
import ua.sukhorutchenko.library.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    void findAllBook() {
        List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());
        books.add(new Book());

        when(bookRepository.findAll()).thenReturn(books);

        assertEquals(3, bookService.findAllBook().size());
    }

    @Test
    void findBookById() {
        Book book = new Book();
        book.setId(1L);
        book.setName("Test Name");

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        assertEquals(book.getName(), bookRepository.findById(1L).orElseThrow(NoSuchElementException::new).getName());
    }

    @Test
    void addBook() {
        BookDTO book = new BookDTO();
        bookService.addBook(book);

    }

    @Test
    void deleteBookById() {
        Book book = new Book();
        book.setId(1L);
        book.setName("Test Name");

        bookService.deleteBookById(1L);

        Mockito.verify(bookRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    void updateBook() {
    }

}