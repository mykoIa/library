package ua.sukhorutchenko.library.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.sukhorutchenko.library.dto.BookInformationDTO;
import ua.sukhorutchenko.library.mapper.BookInformationMapper;
import ua.sukhorutchenko.library.repository.BookInformationRepository;
import ua.sukhorutchenko.library.service.interf.BookInformationService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookInformationServiceImpl implements BookInformationService {

    private final BookInformationRepository bookInformationRepository;
    private final BookInformationMapper bookInformationMapper;

    public BookInformationServiceImpl(BookInformationRepository bookInformationRepository, BookInformationMapper bookInformationMapper) {
        this.bookInformationRepository = bookInformationRepository;
        this.bookInformationMapper = bookInformationMapper;
    }

    @Transactional
    public BookInformationDTO findBookInformationById(Long id) {
        return bookInformationMapper.entityToDTO(bookInformationRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Transactional
    public List<BookInformationDTO> findAllBookInformation() {
        return bookInformationMapper.entityToDTO(bookInformationRepository.findAll());
    }

    @Transactional
    public void addBookInformation(BookInformationDTO bookInformation) {
        bookInformationRepository.save(bookInformationMapper.dtoToEntity(bookInformation));
    }

    @Transactional
    public void deleteBookInformationById(Long id) {
        bookInformationRepository.deleteById(id);
    }

    @Transactional
    public void updateBookInformation(BookInformationDTO bookInfoDTO) {
        BookInformationDTO bookInfo = findBookInformationById(bookInfoDTO.getId());
        bookInfo.setGenre(bookInfoDTO.getGenre());
        bookInfo.setNumberOfPages(bookInfoDTO.getNumberOfPages());
        bookInformationRepository.save(bookInformationMapper.dtoToEntity(bookInfo));
    }

}
