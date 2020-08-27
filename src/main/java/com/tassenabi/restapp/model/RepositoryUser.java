package com.tassenabi.restapp.model;

import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.data.dao.IdaoEntity;

import java.util.List;

public class RepositoryUser implements IRepositoryUser {

    //TODO Dependency Injection Container für Java finden, analaog Ninject C#
    //Repository soll so nichts von dem DAO wissen
    private IdaoEntity daoUser;

    public RepositoryUser(IdaoEntity daoUser){

        this.daoUser = daoUser;
    }

    public User getUser(String name){

        return daoUser.getUser(name);
    }

    @Override
    public void updateUser(String oldUserName, String newUserName) {

        daoUser.updateUser(oldUserName, newUserName);
    }

    @Override
    public void deleteUser(String userName) {
        daoUser.deleteUser(userName);
    }

    @Override
    public void insertUser(String userName) {
        daoUser.insertUser(userName);
    }

    public List<User> getAllUser(){

        return daoUser.getAllUser();
    }
}