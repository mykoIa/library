package ua.sukhorutchenko.library.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.sukhorutchenko.library.dto.AuthorDTO;
import ua.sukhorutchenko.library.mapper.AuthorMapper;
import ua.sukhorutchenko.library.repository.AuthorRepository;
import ua.sukhorutchenko.library.service.interf.AuthorService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Transactional
    public List<AuthorDTO> findAllAuthor() {
        return authorMapper.entityToDTO(authorRepository.findAll());
    }

    @Transactional
    public AuthorDTO findAuthorById(Long id) {
        return authorMapper.entityToDTO(authorRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Transactional
    public void addAuthor(AuthorDTO author) {
        authorRepository.save(authorMapper.dtoToEntity(author));
    }

    @Transactional
    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }

    @Transactional
    public void updateAuthor(AuthorDTO authorDTO) {
        AuthorDTO author = findAuthorById(authorDTO.getId());
        author.setFullName(authorDTO.getFullName());
        authorRepository.save(authorMapper.dtoToEntity(authorDTO));
    }

}
