package ua.sukhorutchenko.library.service;

import ua.sukhorutchenko.library.model.Book;
import ua.sukhorutchenko.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findBookById(Long id){
        return bookRepository.getOne(id);
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

    public void updateBook(Long id){
        bookRepository.existsById(id);
    }
}

//    create read update delete