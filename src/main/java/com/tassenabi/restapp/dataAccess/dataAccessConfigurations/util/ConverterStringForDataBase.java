package com.tassenabi.restapp.dataAccess.dataAccessConfigurations.util;

public class ConverterStringForDataBase {

    private ConverterStringForDataBase() {
        throw new IllegalStateException("Utility class");
    }

    public static String formatUserNameForDatabase(String name){

    //Because every string should start with a Capital, Rest lowerCases and not should not include spaces
    name = name.trim();
    int countLettersName = name.length();
    String firstLetter = name.substring(0,1).toUpperCase();
    String lastLetters = name.substring(1,countLettersName).toLowerCase();

    name = firstLetter + lastLetters;
    name = name.trim();

    return name;

    }
}