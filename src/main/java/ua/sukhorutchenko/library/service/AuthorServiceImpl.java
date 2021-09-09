package ua.sukhorutchenko.library.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.sukhorutchenko.library.entity.Author;
import ua.sukhorutchenko.library.repository.AuthorRepository;
import ua.sukhorutchenko.library.service.interf.AuthorService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public List<Author> findAllAuthor() {
        return authorRepository.findAll();
    }

    @Transactional
    public Author findAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }

    @Transactional
    public void updateAuthor(Author author, String name) {
        author.setFullName(name);
        authorRepository.save(author);
    }

}
