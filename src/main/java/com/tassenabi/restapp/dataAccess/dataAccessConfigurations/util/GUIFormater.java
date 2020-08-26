package com.tassenabi.restapp.dataAccess.dataAccessConfigurations.util;

public class GUIFormater {

    private GUIFormater(){
        throw new IllegalStateException("");
    }

    public static String formattingToEUR(String value) {

        value = value + " EUR";

        return value;
    }

    public static String formattingToNights(String value) {

        value = value + " nights";

        return value;
    }

}
