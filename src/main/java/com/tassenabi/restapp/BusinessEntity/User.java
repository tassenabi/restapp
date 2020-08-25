package com.tassenabi.restapp.BusinessEntity;

public class User {

    //TODO Lombok benutzen
    private int primaryKey;
    private String userName;

    public User(){

    }

    public User(String userName) {

        this.userName = userName;

    }

    public User(int primaryKey, String userName) {

        this.primaryKey = primaryKey;
        this.userName = userName;
    }

    public int getPrimaryKey() {
        return this.primaryKey;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPrimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }

}