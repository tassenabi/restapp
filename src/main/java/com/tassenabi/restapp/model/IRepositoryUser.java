package com.tassenabi.restapp.model;

import com.tassenabi.restapp.entity.User;
import java.util.List;
import java.util.Optional;

/**
 * If there will be more then repository (for another entity) then a marker interface would be
 * required --> in case with just one entity, even this Interface is not necessary
 */
public interface IRepositoryUser {

    List<User> getAllUser();
    Optional<User> getUser(User user);
    void updateUser(User oldUser, User newUser);
    void deleteUser(User user);
    void insertUser(User user);
}