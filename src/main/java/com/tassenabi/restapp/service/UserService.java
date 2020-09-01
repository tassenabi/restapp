package com.tassenabi.restapp.service;

import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.model.IRepositoryUser;

import java.util.List;
import java.util.Optional;

public class UserService {

    private IRepositoryUser userRepository;

    public UserService(IRepositoryUser userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
        return userRepository.getAllUser();
    }

    public Optional<User> getUser(User user){
        return userRepository.getUser(user);
    }

    public void deleteUser(User user){
        userRepository.deleteUser(user);
    }

    public void updateUser(User oldUser, User newUser){
        userRepository.updateUser(oldUser, newUser);
    }

    public void insertUser(User user){
        userRepository.insertUser(user);
    }
}