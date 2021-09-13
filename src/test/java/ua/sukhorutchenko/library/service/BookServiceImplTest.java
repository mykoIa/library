package ua.sukhorutchenko.library.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.sukhorutchenko.library.dto.BookDTO;
import ua.sukhorutchenko.library.entity.Author;
import ua.sukhorutchenko.library.entity.Book;
import ua.sukhorutchenko.library.entity.BookInformation;
import ua.sukhorutchenko.library.entity.Publisher;
import ua.sukhorutchenko.library.repository.AuthorRepository;
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
    private AuthorServiceImpl authorService;

    @Mock
    private PublisherServiceImpl publisherService;

    @Mock
    private BookInformationServiceImpl bookInformationService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorRepository authorRepository;

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
        BookDTO bookDTO = new BookDTO();
        bookDTO.setName("Test Name");

        List<Author> authorsIds = new ArrayList<>();
        authorsIds.add(new Author());
        authorsIds.get(0).setId(1L);
        authorsIds.add(new Author());
        authorsIds.get(1).setId(2L);
        authorsIds.add(new Author());
        authorsIds.get(2).setId(3L);
        bookDTO.setAuthor(authorsIds);

        List<Author> getAuthors = new ArrayList<>();
        getAuthors.add(new Author());
        getAuthors.get(0).setId(1L);
        getAuthors.get(0).setFullName("test1");
        getAuthors.add(new Author());
        getAuthors.get(1).setId(2L);
        getAuthors.get(1).setFullName("test2");
        getAuthors.add(new Author());
        getAuthors.get(2).setId(3L);
        getAuthors.get(2).setFullName("test3");

        when(authorService.findAuthorById(1L)).thenReturn(getAuthors.get(0));
        when(authorService.findAuthorById(2L)).thenReturn(getAuthors.get(1));
        when(authorService.findAuthorById(3L)).thenReturn(getAuthors.get(2));

        Publisher publisherId = new Publisher();
        publisherId.setId(1L);
        bookDTO.setPublisher(publisherId);

        Publisher publisher = new Publisher();
        publisher.setId(1L);
        publisher.setPublisherName("test publisher name");

        when(publisherService.findPublisherById(1L)).thenReturn(publisher);

        BookInformation bookInformationId = new BookInformation();
        bookInformationId.setId(1L);
        bookDTO.setBookInformation(bookInformationId);

        BookInformation bookInformation = new BookInformation();
        bookInformation.setId(1L);
        bookInformation.setGenre("adventure");
        bookInformation.setNumberOfPages(222L);

        when(bookInformationService.findBookInformationById(1L)).thenReturn(bookInformation);

        bookService.addBook(bookDTO);
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