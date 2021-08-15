package ua.sukhorutchenko.library.service;

import org.springframework.stereotype.Service;
import ua.sukhorutchenko.library.entity.BookInformation;
import ua.sukhorutchenko.library.repository.BookInformationRepository;
import ua.sukhorutchenko.library.service.interf.BookInformationService;

import java.util.List;

@Service
public class BookInformationServiceImpl implements BookInformationService {

    private final BookInformationRepository bookInformationRepository;

    public BookInformationServiceImpl(BookInformationRepository bookInformationRepository) {
        this.bookInformationRepository = bookInformationRepository;
    }

    public BookInformation findBookInformationById(Long id) {
        return bookInformationRepository.findById(id).get();
    }

    public List<BookInformation> findAllBookInformation() {
        return bookInformationRepository.findAll();
    }

    public BookInformation addBookInformation(BookInformation bookInformation) {
        return bookInformationRepository.save(bookInformation);
    }

    public void deleteBookInformationById(Long id) {
        bookInformationRepository.deleteById(id);
    }

    public void updateBookInformation(BookInformation bookInfo, String genre, Long numberOfPages) {
        bookInfo.setGenre(genre);
        bookInfo.setNumberOfPages(numberOfPages);
        bookInformationRepository.save(bookInfo);
    }

}
