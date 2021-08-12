package ua.sukhorutchenko.library.service.interf;

import ua.sukhorutchenko.library.entity.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAllAuthor();

    Author findAuthorById(Long id);

    Author addAuthor(Author author);

    void deleteAuthorById(Long id);

    void updateAuthor(Author author, String name);
}
