package com.tassenabi.restapp.model;

import com.tassenabi.restapp.businessEntity.User;
import com.tassenabi.restapp.dataAccess.dao.DAOEntity;

import java.util.List;

public class RepositoryUser implements IRepository{

    //TODO Dependency Injection Container benutzen
    private DAOEntity daoUser;

    public RepositoryUser(DAOEntity daoUser){

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