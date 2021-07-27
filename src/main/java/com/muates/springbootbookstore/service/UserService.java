package com.muates.springbootbookstore.service;

import com.muates.springbootbookstore.domain.User;
import com.muates.springbootbookstore.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.getById(id);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void updateUserById(Long id, User user){

        User existUser = getUserById(id);

        if(existUser == null){
            throw new NoSuchElementException("User with id" + id + " does not found!");
        }

        existUser.setFirstName(user.getFirstName());
        existUser.setLastName(user.getLastName());
        existUser.setMail(user.getMail());

        userRepository.save(existUser);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
