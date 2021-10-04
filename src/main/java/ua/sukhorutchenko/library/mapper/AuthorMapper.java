package ua.sukhorutchenko.library.mapper;

import org.mapstruct.Mapper;
import ua.sukhorutchenko.library.dto.AuthorDTO;
import ua.sukhorutchenko.library.entity.Author;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDTO entityToDTO(Author author);

    Author dtoToEntity(AuthorDTO authorDTO);

    List<AuthorDTO> entityToDTO(List<Author> authors);

}
