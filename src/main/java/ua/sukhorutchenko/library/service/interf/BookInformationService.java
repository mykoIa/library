package ua.sukhorutchenko.library.service.interf;

import ua.sukhorutchenko.library.dto.BookInformationDTO;

import java.util.List;

public interface BookInformationService {

    BookInformationDTO findBookInformationById(Long id);

    List<BookInformationDTO> findAllBookInformation();

    void addBookInformation(BookInformationDTO bookInformation);

    void deleteBookInformationById(Long id);

    void updateBookInformation(BookInformationDTO bookInfo);

}
