package com.muates.springbootbookstore.service;

import com.muates.springbootbookstore.domain.Gender;
import com.muates.springbootbookstore.domain.User;
import com.muates.springbootbookstore.exception.ResourceNotFoundException;
import com.muates.springbootbookstore.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final GenderService genderService;

    public UserService(UserRepository userRepository, GenderService genderService) {
        this.userRepository = userRepository;
        this.genderService = genderService;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User does not found!"));
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void updateUserById(Long id, User user){
        getUserById(id);
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        User user = getUserById(id);
        if (user == null) {
            throw new ResourceNotFoundException("User does not found!");
        }
        userRepository.deleteById(id);
    }

    public List<User> getAllUsersByGender(String gender) {

        List<User> userList = getAllUsers();

        if (gender.equals("male")) {
            return userList.stream().filter(user -> user.getGender().getGender().equals("Male")).collect(Collectors.toList());
        } else if (gender.equals("female")) {
            return userList.stream().filter(user -> user.getGender().getGender().equals("Female")).collect(Collectors.toList());
        }

        return null;
    }

    public List<User> getAllUserByGenderFromRepo(String gender) {
        Gender existingGender = genderService.getGenderByGender(gender);
        return userRepository.findAllByGender(existingGender);
    }

}
