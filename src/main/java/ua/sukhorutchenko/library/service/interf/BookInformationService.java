package ua.sukhorutchenko.library.service.interf;


import org.springframework.stereotype.Service;
import ua.sukhorutchenko.library.entity.BookInformation;

import java.util.List;

@Service
public interface BookInformationService {

    BookInformation findBookInformationById(Long id);

    List<BookInformation> findAllBookInformation();

    BookInformation addBookInformation(BookInformation bookInformation);

    void deleteBookInformationById(Long id);

    void updateBookInformation(BookInformation bookInfo, String genre, Long numberOfPages);
}
