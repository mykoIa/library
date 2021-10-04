package ua.sukhorutchenko.library.mapper;

import org.mapstruct.Mapper;
import ua.sukhorutchenko.library.dto.BookInformationDTO;
import ua.sukhorutchenko.library.entity.BookInformation;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookInformationMapper {

    BookInformationDTO entityToDTO(BookInformation bookInformation);

    BookInformation dtoToEntity(BookInformationDTO bookInformationDTO);

    List<BookInformationDTO> entityToDTO(List<BookInformation> bookInformation);

}