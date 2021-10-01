package ua.sukhorutchenko.library.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.sukhorutchenko.library.dto.AuthorDTO;
import ua.sukhorutchenko.library.entity.Author;
import ua.sukhorutchenko.library.mapper.AuthorMapper;
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

    @Mock
    private AuthorMapper authorMapper;

    @Test
    void findAllAuthor() {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author());
        authors.add(new Author());
        authors.add(new Author());

        List<AuthorDTO> authorsDTO = new ArrayList<>();
        authorsDTO.add(new AuthorDTO());
        authorsDTO.add(new AuthorDTO());
        authorsDTO.add(new AuthorDTO());

        when(authorRepository.findAll()).thenReturn(authors);
        when(authorService.findAllAuthor()).thenReturn(authorsDTO);

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
        author.setId(1L);
        author.setFullName("Test Name");

        authorService.addAuthor(authorMapper.entityToDTO(author));
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
        AuthorDTO authorById = new AuthorDTO();
        authorById.setId(1L);
        authorById.setFullName("Test Name");

        Mockito.when(authorMapper.entityToDTO(author)).thenReturn(authorById);
        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));

        authorById = authorService.findAuthorById(1L);
        authorById.setFullName("Update Name");
        authorService.updateAuthor(authorById);

        Mockito.verify(authorRepository, Mockito.times(1)).save(authorMapper.dtoToEntity(authorById));
    }
}