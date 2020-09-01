package com.tassenabi.restapp.data.querygenerator.jpa;

import com.tassenabi.restapp.data.querygenerator.QueryGeneratorUser;

public class QueryJpaGeneratorUser extends QueryGeneratorUser {

    private QueryJpaGeneratorUser(){

    }

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
