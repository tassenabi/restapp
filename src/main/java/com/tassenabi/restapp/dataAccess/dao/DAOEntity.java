package com.tassenabi.restapp.dataAccess.dao;

import com.tassenabi.restapp.businessEntity.User;
import java.util.List;

public interface DAOEntity {

    List<User> getAllUser();
    User getUser(String userName);
    void deleteUser(String userName);
    void updateUser(String oldUserName, String newUserName);
    void insertUser(String userName);
}
