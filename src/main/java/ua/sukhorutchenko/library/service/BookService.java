package ua.sukhorutchenko.library.service;

import org.springframework.stereotype.Service;
import ua.sukhorutchenko.library.entity.Book;
import ua.sukhorutchenko.library.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBook(){
        return bookRepository.findAll();
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id).get();
    }
}
