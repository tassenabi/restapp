package com.tassenabi.restapp.DataAccess.QueryGenerator;

public class QueryGeneratorUser {

    public static final String TABLENAME = "TBL_USER";
    public static final String COLUMN1 = "PK_id";
    public static final String COLUMN2 = "TXT_userName";


    public static String fetchQueryOneUser(String userName) {

        String query = "SELECT " + COLUMN1  + ", " + COLUMN2 + " from " + TABLENAME + " WHERE " + COLUMN2 + " = " + "'" + userName + "'";

        return query;
    }

    public static String fetchQueryAllUser() {

        String query = "SELECT * FROM " + TABLENAME;

        return query;
    }

    public static String deleteQueryUser(String userName) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN2 + "=" + "'" + userName + "'";

        return query;
    }

    public static String insertUserQuery(String userName) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + ") VALUES (? ," + "'" + userName + "'" + ")";

        return query;
    }

    public static String updateUserQuery(String oldUserName, String newUserName){

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + "'"+ newUserName + "'" + " WHERE " + COLUMN2 + " = " + "'" + oldUserName + "'";

        return query;
    }

    @Override
    public String toString() {

        return this.getClass().getName();
    }
    public static void main(String[] args) {
        System.out.println(updateUserQuery("Robert", "Robert2"));
        System.out.println(insertUserQuery("Robert"));
        System.out.println(deleteQueryUser("Robert"));
        System.out.println(fetchQueryOneUser("Robert"));
        System.out.println(fetchQueryAllUser());



    }
}
