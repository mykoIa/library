package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.*;
import ua.sukhorutchenko.library.dto.UserDTO;
import ua.sukhorutchenko.library.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<UserDTO> showAllUsers() {
        return userService.findAllUser();
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public UserDTO findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public void addUser(@RequestBody UserDTO user) {
        userService.addUser(user);
    }

    @PutMapping("/update")
    @ResponseBody
    public void updateUser(@RequestBody UserDTO user) {
        userService.updateUser(user);
    }

}
