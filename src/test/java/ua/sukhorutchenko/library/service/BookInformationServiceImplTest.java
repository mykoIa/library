package ua.sukhorutchenko.library.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.sukhorutchenko.library.dto.BookInformationDTO;
import ua.sukhorutchenko.library.entity.BookInformation;
import ua.sukhorutchenko.library.mapper.BookInformationMapper;
import ua.sukhorutchenko.library.repository.BookInformationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookInformationServiceImplTest {

    @InjectMocks
    private BookInformationServiceImpl bookInformationService;

    @Mock
    private BookInformationRepository bookInformationRepository;

    @Mock
    private BookInformationMapper bookInformationMapper;

    @Test
    void findBookInformationById() {
        List<BookInformation> bookInformations = new ArrayList<>();
        bookInformations.add(new BookInformation());
        bookInformations.add(new BookInformation());
        bookInformations.add(new BookInformation());

        List<BookInformationDTO> bookInformationsDTO = new ArrayList<>();
        bookInformationsDTO.add(new BookInformationDTO());
        bookInformationsDTO.add(new BookInformationDTO());
        bookInformationsDTO.add(new BookInformationDTO());

        when(bookInformationRepository.findAll()).thenReturn(bookInformations);
        when(bookInformationService.findAllBookInformation()).thenReturn(bookInformationsDTO);

        assertEquals(3, bookInformationService.findAllBookInformation().size());
    }

    @Test
    void findAllBookInformation() {
        BookInformation bookInformation = new BookInformation();
        bookInformation.setId(1L);
        bookInformation.setGenre("adve");
        bookInformation.setNumberOfPages(111L);

        when(bookInformationRepository.findById(1L)).thenReturn(Optional.of(bookInformation));

        assertEquals(bookInformation, bookInformationRepository.findById(1L).orElseThrow(NoSuchElementException::new));
    }

    @Test
    void addBookInformation() {
        BookInformation bookInformation = new BookInformation();
        bookInformationService.addBookInformation(bookInformationMapper.entityToDTO(bookInformation));
    }

    @Test
    void deleteBookInformationById() {
        BookInformation bookInformation = new BookInformation();
        bookInformation.setId(1L);
        bookInformation.setGenre("adv");
        bookInformation.setNumberOfPages(111L);

        bookInformationService.deleteBookInformationById(1L);

        Mockito.verify(bookInformationRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    void updateBookInformation() {
        BookInformation bookInformation = new BookInformation();
        bookInformation.setId(1L);
        bookInformation.setGenre("adv");
        bookInformation.setNumberOfPages(111L);
        BookInformationDTO bookInformationById = new BookInformationDTO();
        bookInformationById.setId(1L);
        bookInformationById.setGenre("adv");
        bookInformationById.setNumberOfPages(111L);

        Mockito.when(bookInformationMapper.entityToDTO(bookInformation)).thenReturn(bookInformationById);
        when(bookInformationRepository.findById(1L)).thenReturn(Optional.of(bookInformation));

        bookInformationById = bookInformationService.findBookInformationById(1L);
        bookInformationById.setGenre("update adv");
        bookInformationById.setNumberOfPages(222L);

        bookInformationService.updateBookInformation(bookInformationById);

        Mockito.verify(bookInformationRepository, Mockito.times(1)).save(bookInformationMapper.dtoToEntity(bookInformationById));
    }
}