package ua.sukhorutchenko.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.sukhorutchenko.library.dto.BookDTO;
import ua.sukhorutchenko.library.entity.Book;

import java.util.List;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO toDTO(Book book);

    List<BookDTO> toDTO(List<Book> allBook);

}
