package ua.sukhorutchenko.library.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.sukhorutchenko.library.entity.Author;
import ua.sukhorutchenko.library.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorServiceImplTest {

    @InjectMocks
    private AuthorServiceImpl authorService;

    @Mock
    private AuthorRepository authorRepository;

    @Test
    void findAllAuthor() {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author());
        authors.add(new Author());
        authors.add(new Author());
        when(authorRepository.findAll()).thenReturn(authors);
        assertEquals(3, authorService.findAllAuthor().size());
    }

    @Test
    void findAuthorById() {
        Author author = new Author();
        author.setId(1L);
        author.setFullName("Test Name");

        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));

        assertEquals(author.getFullName(), authorRepository.findById(1L).orElseThrow(NoSuchElementException::new).getFullName());
    }

    @Test
    void addAuthor() {
        Author author = new Author();
        authorService.addAuthor(author);

        Mockito.verify(authorRepository, Mockito.times(1)).save(author);
    }

    @Test
    void deleteAuthorById() {
        Author author = new Author();
        author.setId(1L);
        author.setFullName("Test Name");

        authorService.deleteAuthorById(1L);

        Mockito.verify(authorRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    void updateAuthor() {
        Author author = new Author();
        author.setId(1L);
        author.setFullName("Test Name");

        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));

        Author authorById = authorService.findAuthorById(1L);
        authorById.setFullName("Update Name");
        authorService.updateAuthor(authorById, "Test Name");
        
        Mockito.verify(authorRepository, Mockito.times(1)).save(authorById);
    }
}