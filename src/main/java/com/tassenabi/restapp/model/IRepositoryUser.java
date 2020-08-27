package com.tassenabi.restapp.model;

import com.tassenabi.restapp.entity.User;
import java.util.List;

/**
 * If there will be more then repository (for another entity) then a marker interface would be
 * required --> in case with just one entity, even this Interface is not necessary
 */
public interface IRepositoryUser {

    List<User> getAllUser();
    User getUser(String name);
    void updateUser(String oldUserName, String newUserName);
    void deleteUser(String userName);
    void insertUser(String userName);
}
