package ua.sukhorutchenko.library.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.sukhorutchenko.library.dto.BookDTO;
import ua.sukhorutchenko.library.mapper.BookMapper;
import ua.sukhorutchenko.library.repository.BookRepository;
import ua.sukhorutchenko.library.service.interf.BookService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Transactional
    public List<BookDTO> findAllBook() {
        return bookMapper.entityToDTO(bookRepository.findAll());
    }

    @Transactional
    public BookDTO findBookById(Long id) {
        return bookMapper.entityToDTO(bookRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Transactional
    public void addBook(BookDTO book) {
        bookRepository.save(bookMapper.dtoToEntity(book));
    }

    @Transactional
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public void updateBook(BookDTO bookDTO) {
        BookDTO bookUpdate = findBookById(bookDTO.getId());
        bookUpdate.setName(bookDTO.getName());
        bookUpdate.setAuthor(bookDTO.getAuthor());
        bookUpdate.setPublisher(bookDTO.getPublisher());
        bookUpdate.setBookInformation(bookDTO.getBookInformation());
        bookRepository.save(bookMapper.dtoToEntity(bookUpdate));
    }

}
