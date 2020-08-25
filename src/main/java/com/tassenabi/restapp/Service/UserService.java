package com.tassenabi.restapp.Service;

import com.tassenabi.restapp.BusinessEntity.User;
import com.tassenabi.restapp.Model.IRepository;

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
}