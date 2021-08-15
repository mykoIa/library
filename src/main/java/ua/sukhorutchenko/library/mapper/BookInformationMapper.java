package ua.sukhorutchenko.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.sukhorutchenko.library.dto.BookInformationDTO;
import ua.sukhorutchenko.library.entity.BookInformation;

import java.util.List;

@Mapper
public interface BookInformationMapper {

    BookInformationMapper INSTANCE = Mappers.getMapper(BookInformationMapper.class);

    BookInformationDTO toDTO(BookInformation bookInformation);

    List<BookInformationDTO> toDTO(List<BookInformation> allBookInformation);

}
