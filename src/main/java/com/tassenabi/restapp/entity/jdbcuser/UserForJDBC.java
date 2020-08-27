package com.tassenabi.restapp.entity.jdbcuser;

import com.tassenabi.restapp.entity.User;

/**
 * Entity User for the JDCB Database Fetch
 */
//TODO Lombok Project Refactoring
public class UserForJDBC extends User {

    private int id;
    private String userName;

    public UserForJDBC(){
        super();
    }

    public UserForJDBC(String userName){ super(userName);}

    public UserForJDBC(int primaryKey, String userName){
        super(primaryKey, userName);
    }

    @Override
    public int getId() {
        return this.id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(int id) {
        this.id = id;
    }

}