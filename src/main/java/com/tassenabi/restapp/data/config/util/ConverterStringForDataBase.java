package com.tassenabi.restapp.data.config.util;

public class ConverterStringForDataBase {

    /** Private Constructor because it is a static utility class
     */
    private ConverterStringForDataBase() {
        throw new IllegalStateException("Utility class");
    }

    public static String formatUserNameForDatabase(String userName){

        //Because every string should start with a Capital, Rest lowerCases and not should not include spaces
        userName = userName.trim();
        int countLettersName = userName.length();
        String firstLetter = userName.substring(0,1).toUpperCase();

        String lastLetters = userName.substring(1,countLettersName).toLowerCase();


        userName = firstLetter + lastLetters;
        userName = userName.trim();

    return userName;

    }
}