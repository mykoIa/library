package ua.sukhorutchenko.library.service.interf;

import ua.sukhorutchenko.library.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {

    List<AuthorDTO> findAllAuthor();

    AuthorDTO findAuthorById(Long id);

    void addAuthor(AuthorDTO author);

    void deleteAuthorById(Long id);

    void updateAuthor(AuthorDTO author);

}
