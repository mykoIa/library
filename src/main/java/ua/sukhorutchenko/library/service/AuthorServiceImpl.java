package ua.sukhorutchenko.library.service;

import org.springframework.stereotype.Service;
import ua.sukhorutchenko.library.entity.Author;
import ua.sukhorutchenko.library.repository.AuthorRepository;
import ua.sukhorutchenko.library.service.interf.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAllAuthor() {
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long id) {
        return authorRepository.findById(id).get();
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }

    public void updateAuthor(Author author, String name) {
        author.setFullName(name);
        authorRepository.save(author);
    }

}
