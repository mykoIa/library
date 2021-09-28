package ua.sukhorutchenko.library.mapper;

import org.mapstruct.Mapper;
import ua.sukhorutchenko.library.dto.BookDTO;
import ua.sukhorutchenko.library.entity.Book;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO entityToDTO(Book book);

    Book dtoToEntity(BookDTO bookDTO);

    List<BookDTO> entityToDTO(List<Book> books);

}
