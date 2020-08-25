package com.tassenabi.restapp.Model;

import com.tassenabi.restapp.BusinessEntity.User;

import java.util.List;

public interface IRepository {

    List<User> getAllUser();
    User getUser(String name);
    void updateUser(String oldUserName, String newUserName);
    void deleteUser(String userName);
    void insertUser(String userName);
}
