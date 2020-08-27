package com.tassenabi.restapp.entity.jdbcuser;

import com.tassenabi.restapp.entity.User;

/**
 * Entity User for the JDCB Database Fetch
 */
//TODO Lombok Project Refactoring
public class UserForJDBC extends User {

    public UserForJDBC(){
        super();
    }

    public UserForJDBC(int primaryKey, String userName){
        super(primaryKey, userName);
    }
}