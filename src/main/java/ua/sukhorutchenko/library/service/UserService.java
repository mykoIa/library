package ua.sukhorutchenko.library.service;

import ua.sukhorutchenko.library.model.User;
import ua.sukhorutchenko.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long id){
        return userRepository.getOne(id);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public void updateUser(Long id){
        userRepository.existsById(id);
    }
}

//    create read update delete