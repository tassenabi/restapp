package com.tassenabi.restapp.data.querygenerator.jdbc;

import com.tassenabi.restapp.data.querygenerator.QueryGeneratorUser;

public class QueryJdbcGeneratorUser extends QueryGeneratorUser {

    private QueryJdbcGeneratorUser(){

    }

    public static String fetchQueryOneUser() {

        return "SELECT " + COLUMN1  + ", " + COLUMN2 + " from " + TABLENAME + WHERE + COLUMN2 + " = " + " ? ";

    }

    public static String fetchQueryAllUser() {

        return "SELECT * FROM " + TABLENAME;

    }

    public static String deleteQueryUser() {

        return "DELETE FROM " + TABLENAME + WHERE + COLUMN2 + "=" + " ? ";

    }

    public static String insertUserQuery() {

        return "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + ") VALUES (? ," + " ? " + ")";

    }

    public static String updateUserQuery(){

        return "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + " ? " + WHERE + COLUMN2 + " = " + " ? ";

    }

    @Override
    public String toString() {

        return this.getClass().getName();
    }
}