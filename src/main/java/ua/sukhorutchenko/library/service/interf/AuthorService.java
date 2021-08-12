package ua.sukhorutchenko.library.service.interf;

import org.springframework.stereotype.Service;
import ua.sukhorutchenko.library.entity.Author;

import java.util.List;

@Service
public interface AuthorService {

    List<Author> findAllAuthor();

    Author findAuthorById(Long id);

    Author addAuthor(Author author);

    void deleteAuthorById(Long id);

    void updateAuthor(Author author, String name);
}
