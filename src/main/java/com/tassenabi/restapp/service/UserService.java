package com.tassenabi.restapp.service;

import com.tassenabi.restapp.businessEntity.User;
import com.tassenabi.restapp.model.IRepository;

import java.util.List;

public class UserService {

    private IRepository userRepository;

    public UserService(IRepository userRepository){
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