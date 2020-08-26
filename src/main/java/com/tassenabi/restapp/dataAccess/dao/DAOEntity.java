package com.tassenabi.restapp.dataAccess.dao;

import com.tassenabi.restapp.businessEntity.User;
import java.util.List;

public interface DAOEntity {

    List<User> getAllUser();
    User getUser(String name);
    void deleteUser(String name);
    void updateUser(String oldUserName, String newUserName);
    void insertUser(String userName);
}
