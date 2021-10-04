package ua.sukhorutchenko.library.mapper;

import org.mapstruct.Mapper;
import ua.sukhorutchenko.library.dto.PublisherDTO;
import ua.sukhorutchenko.library.entity.Publisher;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherDTO entityToDTO(Publisher publisher);

    Publisher dtoToEntity(PublisherDTO publisherDTO);

    List<PublisherDTO> entityToDTO(List<Publisher> publishers);

}
