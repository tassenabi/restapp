package com.tassenabi.restapp.businessEntity.jdbcUser;

import com.tassenabi.restapp.businessEntity.User;

//TODO Lombok Project Refactoring
public class UserForJDBC extends User {

    public UserForJDBC(){
        super();
    }

    public UserForJDBC(int primaryKey, String userName){
        super(primaryKey, userName);
    }
}