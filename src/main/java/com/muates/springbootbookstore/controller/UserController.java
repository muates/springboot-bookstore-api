package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.User;
import com.muates.springbootbookstore.dto.UserRequest;
import com.muates.springbootbookstore.dto.UserResponse;
import com.muates.springbootbookstore.repository.UserRepository;
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
//        userList.forEach();
//        userList.stream().map();
//        for
        // List<UserResponse> userResponseList
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
        UserResponse userResponse = convertToUserResponse(userService.getUserById(id));
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<UserResponse> saveUser(@Valid @RequestBody UserRequest userRequest) {
        User savedUser = userService.saveUser(convertToUser(userRequest));
        return ResponseEntity.ok(convertToUserResponse(savedUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable Long id, @Valid @RequestBody UserRequest userRequest) {
        User user = convertToUser(userRequest);
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
                .id(userRequest.getId())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .userName(userRequest.getUsername())
                .mail(userRequest.getMail())
                .tcNo(userRequest.getTcNo())
                .gender(userRequest.getGender())
                .build();
    }

    private UserResponse convertToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userName(user.getUserName())
                .gender(user.getGender())
                .build();
    }
}
