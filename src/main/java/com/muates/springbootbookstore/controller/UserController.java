package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.User;
import com.muates.springbootbookstore.dto.UserConverter;
import com.muates.springbootbookstore.dto.request.UserRequest;
import com.muates.springbootbookstore.dto.response.UserResponse;
import com.muates.springbootbookstore.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.ok(UserConverter.convertAllUsersToUserResponses(userList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
        UserResponse userResponse = UserConverter.convertToUserResponse(userService.getUserById(id));
        return ResponseEntity.ok(userResponse);
    }

    // TODO - GetMapping - return all male users
    // TODO - GetMapping - return all female users
    // TODO - GetMapping - pathVariable
    // TODO - GetMapping - requestBody
    // TODO - GetMapping - queryParameter

    @PostMapping({"", "/"})
    public ResponseEntity<UserResponse> saveUser(@Valid @RequestBody UserRequest userRequest) {
        User savedUser = userService.saveUser(UserConverter.convertToUser(userRequest));
        return ResponseEntity.ok(UserConverter.convertToUserResponse(savedUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable Long id, @Valid @RequestBody UserRequest userRequest) {
        User user = UserConverter.convertToUser(userRequest);
        userService.updateUserById(id, user);
        return ResponseEntity.ok("User is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("User is deleted");
    }

}
