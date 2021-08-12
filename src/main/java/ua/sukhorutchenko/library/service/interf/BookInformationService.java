package ua.sukhorutchenko.library.service.interf;

import ua.sukhorutchenko.library.entity.BookInformation;

import java.util.List;

public interface BookInformationService {

    BookInformation findBookInformationById(Long id);

    List<BookInformation> findAllBookInformation();

    BookInformation addBookInformation(BookInformation bookInformation);

    void deleteBookInformationById(Long id);

    void updateBookInformation(BookInformation bookInfo, String genre, Long numberOfPages);
}
