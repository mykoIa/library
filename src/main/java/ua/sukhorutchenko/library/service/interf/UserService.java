package ua.sukhorutchenko.library.service.interf;

import ua.sukhorutchenko.library.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAllUser();

    UserDTO findUserById(Long id);

    void addUser(UserDTO user);

    void deleteUserById(Long id);

    void updateUser(UserDTO user);

}
