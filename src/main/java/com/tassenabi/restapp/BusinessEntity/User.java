package com.tassenabi.restapp.BusinessEntity;

public class User {

    //TODO Lombok Project Refactoring
    private int primaryKey;
    private String userName;

    public User(){

    }

    public User(int primaryKey, String userName){

        this.primaryKey = primaryKey;
        this.userName = userName;

    }

    public int getId() {
        return this.primaryKey;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(int id) {
        this.primaryKey = id;
    }
}