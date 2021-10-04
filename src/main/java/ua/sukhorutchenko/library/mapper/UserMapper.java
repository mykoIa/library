package ua.sukhorutchenko.library.mapper;

import org.mapstruct.Mapper;
import ua.sukhorutchenko.library.dto.UserDTO;
import ua.sukhorutchenko.library.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO entityToDTO(User user);

    User dtoToEntity(UserDTO userDTO);

    List<UserDTO> entityToDTO(List<User> user);

}
