package ua.sukhorutchenko.library.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ua.sukhorutchenko.library.entity.Author;
import ua.sukhorutchenko.library.repository.AuthorRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AuthorServiceImplTest {

    @Autowired
    private AuthorServiceImpl authorService;

    @MockBean
    private AuthorRepository authorRepository;

    @Test
    void findAllAuthor() {
        Mockito.doReturn(new Author())
                .when(authorRepository)
                .findAll();
        Mockito.verify(authorRepository, Mockito.times(1)).findAll();
    }

    @Test
    void findAuthorById() {
        Author author = new Author();
        author.setId(1L);
        Mockito.doReturn(new Author())
                .when(authorRepository)
                .findById(1L);
        Mockito.verify(authorRepository, Mockito.times(1)).findById(1L);
    }

    @Test
    void addAuthor() {
        Author author = new Author();
        authorService.addAuthor(author);
        Mockito.verify(authorRepository, Mockito.times(1)).save(author);
    }

    @Test
    void deleteAuthorById() {
    }

    @Test
    void updateAuthor() {
    }
}