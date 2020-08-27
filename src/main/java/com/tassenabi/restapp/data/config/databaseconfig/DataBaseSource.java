package com.tassenabi.restapp.data.config.databaseconfig;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataBaseSource {

    private static String DATABASEDRIVERNAME;
    private static File DATABASEPATH;
    private static String DATABASENAME;
    private static File TESTDATABASEPATH;
    private static String TESTDATABASENAME;

    //Private Constructor because this is a utility class
    private DataBaseSource(){
        throw new IllegalStateException("DataBaseSource.class is a utility class and should not be an instance");
    }

    public static String getDataBaseLink(){

        concatDatabaseConnectionString();

        return DATABASEDRIVERNAME + DATABASEPATH.getAbsolutePath()+ "/" + DATABASENAME;
    }

    public static String getTestDataBaseLink(){

        return DATABASEDRIVERNAME + TESTDATABASEPATH.getAbsolutePath()+ "/" + TESTDATABASENAME;
    }

    public static void getInfoSourceLinkDataBase(){
        JOptionPane.showMessageDialog(null,"The database of this application is : " +
                "located here: " + DATABASEPATH.getAbsolutePath()+ "/" + DATABASENAME);
    }

    public static void getInfoSourceLinkDTestataBase(){
        JOptionPane.showMessageDialog(null,"The database of this application is : " +
                "located here: " + TESTDATABASEPATH.getAbsolutePath()+ "/" + TESTDATABASENAME);
    }

    private static void concatDatabaseConnectionString()  {

        String absPath = new File("").getAbsolutePath();
        String appConfigPath = absPath + "//src//main//java//com//tassenabi//restapp//data//dataAccessConfigurations//dbConfig//dbConfig.properties";

        Properties appProps = new Properties();

        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e ) {
            e.printStackTrace();
        }

        DATABASEDRIVERNAME = appProps.getProperty("DATABASEDRIVERNAME");

        DATABASEPATH = new File(appProps.getProperty("DATABASEPATH"));
        DATABASENAME = appProps.getProperty("DATABASENAME");

        TESTDATABASEPATH = new File(appProps.getProperty("TESTDATABASEPATH"));
        TESTDATABASENAME = appProps.getProperty("TESTDATABASENAME");

    }
}