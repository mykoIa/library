package ua.sukhorutchenko.library.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.sukhorutchenko.library.dto.UserDTO;
import ua.sukhorutchenko.library.mapper.UserMapper;
import ua.sukhorutchenko.library.repository.UserRepository;
import ua.sukhorutchenko.library.service.interf.UserService;
import ua.sukhorutchenko.library.util.Encoding;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public List<UserDTO> findAllUser() {
        return userMapper.entityToDTO(userRepository.findAll());
    }

    @Transactional
    public UserDTO findUserById(Long id) {
        return userMapper.entityToDTO(userRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Transactional
    public void addUser(UserDTO user) {
        if (userRepository.findByLogin(user.getLogin()) != null) {
            return; //add exception
        }
        user.setRole("user");
        user.setStatus("first_in");
        user.setPassword(Encoding.encodingPassword(user.getPassword()));
        userRepository.save(userMapper.dtoToEntity(user));
    }

    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(UserDTO user) {
        userRepository.save(userMapper.dtoToEntity(user));
    }

    @Transactional
    public UserDTO checkUser(String login, String password) {
        UserDTO userDTO = userMapper.entityToDTO(userRepository.findByLogin(login));
        if (userDTO == null || !Encoding.encodingPassword(password).equals(userDTO.getPassword())) {
            return null; //add exception
        }
        return userDTO;
    }

}
