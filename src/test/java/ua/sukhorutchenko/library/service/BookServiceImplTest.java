package ua.sukhorutchenko.library.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.sukhorutchenko.library.dto.AuthorDTO;
import ua.sukhorutchenko.library.dto.BookDTO;
import ua.sukhorutchenko.library.dto.BookInformationDTO;
import ua.sukhorutchenko.library.dto.PublisherDTO;
import ua.sukhorutchenko.library.entity.Author;
import ua.sukhorutchenko.library.entity.Book;
import ua.sukhorutchenko.library.entity.BookInformation;
import ua.sukhorutchenko.library.entity.Publisher;
import ua.sukhorutchenko.library.mapper.BookMapper;
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

    @Mock
    private BookMapper bookMapper;

    @Test
    void findAllBook() {
        List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());
        books.add(new Book());

        List<BookDTO> booksDTO = new ArrayList<>();
        booksDTO.add(new BookDTO());
        booksDTO.add(new BookDTO());
        booksDTO.add(new BookDTO());

        when(bookRepository.findAll()).thenReturn(books);
        when(bookService.findAllBook()).thenReturn(booksDTO);

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

        List<AuthorDTO> authorsIds = new ArrayList<>();
        authorsIds.add(new AuthorDTO());
        authorsIds.get(0).setId(1L);
        authorsIds.add(new AuthorDTO());
        authorsIds.get(1).setId(2L);
        authorsIds.add(new AuthorDTO());
        authorsIds.get(2).setId(3L);
        bookDTO.setAuthor(authorsIds);

        PublisherDTO publisherId = new PublisherDTO();
        publisherId.setId(1L);
        bookDTO.setPublisher(publisherId);

        BookInformationDTO bookInformationId = new BookInformationDTO();
        bookInformationId.setId(1L);
        bookDTO.setBookInformation(bookInformationId);

        bookService.addBook(bookDTO);

        Mockito.verify(bookRepository).save(bookMapper.dtoToEntity(Mockito.any(BookDTO.class)));

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
        Book bookForUpdate = new Book();
        bookForUpdate.setId(1L);
        bookForUpdate.setName("Test Name");

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
        bookForUpdate.setAuthor(getAuthors);

        Publisher publisher = new Publisher();
        publisher.setId(1L);
        publisher.setPublisherName("test publisher name");
        bookForUpdate.setPublisher(publisher);

        BookInformation bookInformation = new BookInformation();
        bookInformation.setId(1L);
        bookInformation.setGenre("adventure");
        bookInformation.setNumberOfPages(222L);
        bookForUpdate.setBookInformation(bookInformation);

        BookDTO book = new BookDTO();
        book.setId(1L);
        book.setName("update test name");

        List<AuthorDTO> updateAuthor = new ArrayList<>();
        updateAuthor.add(new AuthorDTO());
        updateAuthor.get(0).setId(1L);
        updateAuthor.get(0).setFullName("UP_test1");
        updateAuthor.add(new AuthorDTO());
        updateAuthor.get(1).setId(2L);
        updateAuthor.get(1).setFullName("UP_test2");
        updateAuthor.add(new AuthorDTO());
        updateAuthor.get(2).setId(3L);
        updateAuthor.get(2).setFullName("UP_test3");
        book.setAuthor(updateAuthor);

        PublisherDTO updatePublisher = new PublisherDTO();
        updatePublisher.setId(1L);
        updatePublisher.setPublisherName("UP_test publisher name");
        book.setPublisher(updatePublisher);

        BookInformationDTO updateBookInformation = new BookInformationDTO();
        updateBookInformation.setId(1L);
        updateBookInformation.setGenre("UP_adventure");
        updateBookInformation.setNumberOfPages(222L);
        book.setBookInformation(updateBookInformation);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(bookForUpdate));
        when(bookService.findBookById(1L)).thenReturn(book);

        bookService.updateBook(book);

        Mockito.verify(bookRepository, Mockito.times(1)).save(bookMapper.dtoToEntity(book));

    }

}