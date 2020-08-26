package com.tassenabi.restapp.dataAccess.queryGenerator;

public class QueryGeneratorUser {

    public static final String TABLENAME = "TBL_USER";
    public static final String COLUMN1 = "PK_id";
    public static final String COLUMN2 = "TXT_userName";
    public static final String WHERE = " WHERE ";
    public static final String QUOTATIONMARKS = "'";


    public static String fetchQueryOneUser(String userName) {

        return "SELECT " + COLUMN1  + ", " + COLUMN2 + " from " + TABLENAME + WHERE + COLUMN2 + " = " + QUOTATIONMARKS + userName + QUOTATIONMARKS;

    }

    public static String fetchQueryAllUser() {

        return "SELECT * FROM " + TABLENAME;

    }

    public static String deleteQueryUser(String userName) {

        return "DELETE FROM " + TABLENAME + WHERE + COLUMN2 + "=" + QUOTATIONMARKS + userName + QUOTATIONMARKS;

    }

    public static String insertUserQuery(String userName) {

        return "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + ") VALUES (? ," + QUOTATIONMARKS + userName + QUOTATIONMARKS + ")";

    }

    public static String updateUserQuery(String oldUserName, String newUserName){

        return "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + QUOTATIONMARKS + newUserName + QUOTATIONMARKS + WHERE + COLUMN2 + " = " + QUOTATIONMARKS + oldUserName + QUOTATIONMARKS;

    }

    @Override
    public String toString() {

        return this.getClass().getName();
    }
}
