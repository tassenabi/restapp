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

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "JDBCUser{" +
                "id=" + id +
                ", name='" + userName + '\'' +
                '}';
    }
}