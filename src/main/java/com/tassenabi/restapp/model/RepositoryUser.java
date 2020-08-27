package com.tassenabi.restapp.model;

import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.data.dao.IdaoEntity;
import org.springframework.data.repository.support.Repositories;

import java.util.List;
import java.util.Optional;

public class RepositoryUser implements IRepositoryUser {

    //TODO Dependency Injection Container für Java finden, analaog Ninject C#
    //Repository soll so nichts von dem DAO wissen
    private IdaoEntity daoUser;

    public RepositoryUser(IdaoEntity daoUser){

        this.daoUser = daoUser;
    }

    @Override
    public void updateUser(User oldUser, User newUser) {

        daoUser.update(oldUser, newUser);
    }

    @Override
    public void deleteUser(User user) {
        daoUser.deleteUser(user);
    }

    @Override
    public void insertUser(User user) {
        daoUser.insert(user);
    }

    public List<User> getAllUser(){

        return daoUser.getAll();
    }

    @Override
    public Optional<User> getUser(User user) {
        return Optional.empty();
    }

public static void main(String[] args) {
        User user = new User("Richard");

        RepositoryUser rep = new RepositoryUser();
}

}