package com.tassenabi.restapp.dataAccess.dataAccessConfigurations.dbConfig;

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

    private DataBaseSource(){
        throw new IllegalStateException("");
    }

    private static void concatDatabaseConnectionString()  {

        //TODO Fixed Source replacing
        String appConfigPath ="/Users/tassenabi/IdeaProjects/restfulApp/restapp/src/main/java/com/tassenabi/restapp/dataAccess/dataAccessConfigurations/dbConfig/dbConfig.properties";

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

    public static String getDataBaseLink(){

        concatDatabaseConnectionString();

        return DATABASEDRIVERNAME + DATABASEPATH.getAbsolutePath()+ "/" + DATABASENAME;
    }

    public static String getTestDataBaseLink(){

        return DATABASEDRIVERNAME + TESTDATABASEPATH.getAbsolutePath()+ "/" + TESTDATABASENAME;
    }

    public static void getInfoSourceLinkDataBase(){
        JOptionPane.showMessageDialog(null,"Die Datenbank dieser Anwendung " +
                "liegt unter: " + DATABASEPATH.getAbsolutePath()+ "/" + DATABASENAME);
    }

    public static void getInfoSourceLinkDTestataBase(){
        JOptionPane.showMessageDialog(null,"Die Datenbank dieser Anwendung " +
                "liegt unter: " + TESTDATABASEPATH.getAbsolutePath()+ "/" + TESTDATABASENAME);
    }
}