package com.tassenabi.restapp.entity;

public class User {

    //TODO Lombok Project Refactoring als @data Klasse
    private int id;
    private String userName;

    public User(){

    }

    public User(String userName){
        setUserName(userName);

    }

    public User(int id, String userName){

        this.id = id;
        this.userName = userName;

    }

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

    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + userName + '\'' +
                '}';
    }
}