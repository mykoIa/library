package ua.sukhorutchenko.library.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.sukhorutchenko.library.entity.BookInformation;
import ua.sukhorutchenko.library.repository.BookInformationRepository;
import ua.sukhorutchenko.library.service.interf.BookInformationService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookInformationServiceImpl implements BookInformationService {

    private final BookInformationRepository bookInformationRepository;

    public BookInformationServiceImpl(BookInformationRepository bookInformationRepository) {
        this.bookInformationRepository = bookInformationRepository;
    }

    @Transactional
    public BookInformation findBookInformationById(Long id) {
        return bookInformationRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public List<BookInformation> findAllBookInformation() {
        return bookInformationRepository.findAll();
    }

    @Transactional
    public BookInformation addBookInformation(BookInformation bookInformation) {
        return bookInformationRepository.save(bookInformation);
    }

    @Transactional
    public void deleteBookInformationById(Long id) {
        bookInformationRepository.deleteById(id);
    }

    @Transactional
    public void updateBookInformation(BookInformation bookInfo, String genre, Long numberOfPages) {
        bookInfo.setGenre(genre);
        bookInfo.setNumberOfPages(numberOfPages);
        bookInformationRepository.save(bookInfo);
    }

}
