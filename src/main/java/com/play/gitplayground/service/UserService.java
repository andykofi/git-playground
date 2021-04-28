package com.play.gitplayground.service;


import com.play.gitplayground.Repository.UserRepository;
import com.play.gitplayground.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public List<User> getUserByAddress(String address) {
        return userRepository.findByAddress(address);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
