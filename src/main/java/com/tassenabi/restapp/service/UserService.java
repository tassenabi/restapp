package com.tassenabi.restapp.service;

import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.model.IRepositoryUser;

import java.util.List;

public class UserService {

    private IRepositoryUser userRepository;

    public UserService(IRepositoryUser userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
        return userRepository.getAllUser();
    }

    public User getUser(String name){
        return userRepository.getUser(name);
    }

    public void deleteUser(String userName){
        userRepository.deleteUser(userName);
    }

    public void updateUser(String oldUserName, String newUserName){
        userRepository.updateUser(oldUserName, newUserName);
    }

    public void insertUser(String userName){
        userRepository.insertUser(userName);
    }
}