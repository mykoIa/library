package ua.sukhorutchenko.library.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.sukhorutchenko.library.dto.BookDTO;
import ua.sukhorutchenko.library.entity.Author;
import ua.sukhorutchenko.library.entity.Book;
import ua.sukhorutchenko.library.repository.BookRepository;
import ua.sukhorutchenko.library.service.interf.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {

    private final AuthorServiceImpl authorService;
    private final PublisherServiceImpl publisherService;
    private final BookInformationServiceImpl bookInformationService;
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorServiceImpl authorService, PublisherServiceImpl publisherService, BookInformationServiceImpl bookInformationService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.bookInformationService = bookInformationService;
    }

    @Transactional
    public List<Book> findAllBook() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public void addBook(BookDTO book) {
        bookRepository.save(new Book(book.getName(),
                findAllAuthorBoIds(book.getAuthor()),
                publisherService.findPublisherById(book.getPublisher().getId()),
                bookInformationService.findBookInformationById(book.getBookInformation().getId())));
    }

    @Transactional
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public void updateBook(BookDTO book) {
        Book bookUpdate = findBookById(book.getId());
        bookUpdate.setName(book.getName());
        bookUpdate.setAuthor(findAllAuthorBoIds(book.getAuthor()));
        bookUpdate.setPublisher(book.getPublisher());
        bookUpdate.setBookInformation(book.getBookInformation());
        bookRepository.save(bookUpdate);
    }

    private List<Author> findAllAuthorBoIds(List<Author> authorList) {
        List<Author> result = new ArrayList<>();
        if (authorList == null) {
            return result;
        }
        for(Author author : authorList) {
            result.add(authorService.findAuthorById(author.getId()));
        }
        return result;
    }

}
