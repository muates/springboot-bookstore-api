package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.User;
import com.muates.springbootbookstore.dto.UserRequest;
import com.muates.springbootbookstore.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"","/"})
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping({"", "/"})
    public ResponseEntity<User> saveUser(@Valid @RequestBody UserRequest userRequest) {
        User user = convertToUser(userRequest);
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable Long id, @Valid @RequestBody User user) {
        userService.updateUserById(id, user);
        return ResponseEntity.ok("User is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("User is deleted");
    }

    private User convertToUser(UserRequest userRequest) {
        return User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .username(userRequest.getUsername())
                .mail(userRequest.getMail())
                .tcNo(userRequest.getTcNo())
                .gender(userRequest.getGender())
                .build();
    }
}
