package ua.sukhorutchenko.library.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.sukhorutchenko.library.entity.Author;
import ua.sukhorutchenko.library.entity.BookInformation;
import ua.sukhorutchenko.library.repository.BookInformationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookInformationServiceImplTest {

    @InjectMocks
    private BookInformationServiceImpl bookInformationService;

    @Mock
    private BookInformationRepository bookInformationRepository;

    @Test
    void findBookInformationById() {
        List<BookInformation> bookInformations = new ArrayList<>();
        bookInformations.add(new BookInformation());
        bookInformations.add(new BookInformation());
        bookInformations.add(new BookInformation());

        when(bookInformationRepository.findAll()).thenReturn(bookInformations);

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

//    @Test
//    void addBookInformation() {
//        BookInformation author = new BookInformation();
//        bookInformationService.addBookInformation(author);
//
//        Mockito.verify(bookInformationRepository, Mockito.times(1)).save(author);
//    }

    @Test
    void deleteBookInformationById() {
        BookInformation bookInformation = new BookInformation();
        bookInformation.setId(1L);
        bookInformation.setGenre("adv");
        bookInformation.setNumberOfPages(111L);

        bookInformationService.deleteBookInformationById(1L);

        Mockito.verify(bookInformationRepository, Mockito.times(1)).deleteById(1L);
    }

//    @Test
//    void updateBookInformation() {
//        BookInformation bookInformation = new BookInformation();
//        bookInformation.setId(1L);
//        bookInformation.setGenre("adv");
//        bookInformation.setNumberOfPages(111L);
//
//        when(bookInformationRepository.findById(1L)).thenReturn(Optional.of(bookInformation));
//
//        BookInformation bookInformation1 = bookInformationService.findBookInformationById(1L);
//        bookInformation1.setGenre("update adv");
//        bookInformation1.setNumberOfPages(222L);
//        bookInformationService.updateBookInformation(bookInformation1, "update adv", 222L);
//
//        Mockito.verify(bookInformationRepository, Mockito.times(1)).save(bookInformation1);
//    }
}