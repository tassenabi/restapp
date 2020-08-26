package com.tassenabi.restapp.dataAccess.queryGenerator.QueryJdbcGenerator;

import com.tassenabi.restapp.dataAccess.queryGenerator.QueryGeneratorUser;

public class QueryHibernateGeneratorUser extends QueryGeneratorUser {

        public static String fetchQueryOneUser(String userName) {

            return "SELECT * FROM users WHERE userName=:userId";

        }

        public static String fetchQueryAllUser() {

            return null;

        }

        public static String deleteQueryUser(String userName) {

            return null;

        }

        public static String insertUserQuery(String userName) {

            return null;

        }

        public static String updateUserQuery(String oldUserName, String newUserName){

            return null;

        }

        @Override
        public String toString() {

            return this.getClass().getName();
        }
}
