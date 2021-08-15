package ua.sukhorutchenko.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.sukhorutchenko.library.dto.PublisherDTO;
import ua.sukhorutchenko.library.entity.Publisher;

import java.util.List;

@Mapper
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    PublisherDTO toDTO(Publisher publisher);

    List<PublisherDTO> toDTO(List<Publisher> allPublisher);

}
