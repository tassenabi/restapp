package com.tassenabi.restapp.BusinessEntity.JDBCUser;

import com.tassenabi.restapp.BusinessEntity.User;

public class UserForJDBC extends User {

    public UserForJDBC(){
        super();
    }

    public UserForJDBC(int primaryKey, String userName){
        super(primaryKey, userName);
    }
}