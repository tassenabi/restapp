package com.tassenabi.restapp.data.config.databaseconfig;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataBaseSource {

    private static String databaseDriverName;
    private static File databasePath;
    private static String databaseName;
    private static File testDatabasePath;
    private static String testDatabaseName;

    //Private Constructor because this is a utility class
    private DataBaseSource(){
        throw new IllegalStateException("DataBaseSource.class is a utility class and should not be an instance");
    }

    public static String getDataBaseLink(){

        concatDatabaseConnectionString();

        return databaseDriverName + databasePath.getAbsolutePath()+ "/" + databaseName;
    }

    public static String getTestDataBaseLink(){
        System.out.println(databaseDriverName + testDatabasePath.getAbsolutePath()+ "/" + testDatabaseName);
        return databaseDriverName + testDatabasePath.getAbsolutePath()+ "/" + testDatabaseName;
    }

    public static void getInfoSourceLinkDataBase(){
        JOptionPane.showMessageDialog(null,"The database of this application is : " +
                "located here: " + databasePath.getAbsolutePath()+ "/" + databaseName);
    }

    public static void getInfoSourceLinkDTestataBase(){
        JOptionPane.showMessageDialog(null,"The database of this application is : " +
                "located here: " + testDatabasePath.getAbsolutePath()+ "/" + testDatabaseName);
    }

    private static void concatDatabaseConnectionString()  {

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

        testDatabasePath = new File(appProps.getProperty("TESTDATABASEPATH"));
        testDatabaseName = appProps.getProperty("TESTDATABASENAME");

    }
}