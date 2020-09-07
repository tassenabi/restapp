package com.tassenabi.restapp.data.config.databaseconfig;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataBaseSource {

    private static String getDatabaseClassNameDriver;
    private static String databaseDriverName;
    private static File databasePath;
    private static String databaseName;
    private static String testDatabaseName;

    //Private Constructor because this is a utility class
    private DataBaseSource(){
        throw new IllegalStateException("DataBaseSource.class is a utility class and should not be an instance");
    }

    static{

        readProperties();

    }

    //TODO Refactoring -> 3 times call of concactMethod
    public static String getTestDatabaseName(){

        return testDatabaseName;
    }
    public static String getDataBaseUrl(){

        return databaseDriverName + databasePath.getAbsolutePath()+ "/" + databaseName;
    }

    public static String getTestDataBaseUrl(){

        return databaseDriverName + databasePath.getAbsolutePath()+ "/" + testDatabaseName;
    }

    private static void readProperties()  {

        String absPath = new File("").getAbsolutePath();
        String appConfigPath = absPath + "//src//main//java//com//tassenabi//restapp//data//config//databaseconfig//dbConfig.properties";

        Properties appProps = new Properties();

        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e ) {
            e.printStackTrace();
        }

        databaseDriverName = appProps.getProperty("DATABASEDRIVERNAME");

        databasePath = new File(appProps.getProperty("DATABASEPATH"));
        databaseName = appProps.getProperty("DATABASENAME");

        testDatabaseName = appProps.getProperty("TESTDATABASENAME");
        getDatabaseClassNameDriver = appProps.getProperty("DATABASECLASSNAMEDRIVER");

    }

    public static String getDatabaseClassNameDriver() {

        return getDatabaseClassNameDriver;
    }
    public static void main(String[] args) {
        System.out.println(DataBaseSource.getDatabaseClassNameDriver());
        System.out.println(DataBaseSource.getDataBaseUrl());
    }
}