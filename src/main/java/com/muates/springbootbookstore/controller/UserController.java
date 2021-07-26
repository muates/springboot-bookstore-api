package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.User;
import com.muates.springbootbookstore.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"","/"})
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping({"","/"})
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public void updateUserById(@PathVariable Long id, @RequestBody User user){
        userService.updateUserById(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }
}
