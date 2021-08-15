package ua.sukhorutchenko.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ua.sukhorutchenko.library.dto.AuthorDTO;
import ua.sukhorutchenko.library.entity.Author;

import java.util.List;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    @Mapping(target = "fullName")
    AuthorDTO toDTO(Author author);

    List<AuthorDTO> toDTO(List<Author> allAuthor);

}
