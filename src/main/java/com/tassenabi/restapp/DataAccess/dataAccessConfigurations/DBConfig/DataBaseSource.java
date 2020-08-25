package com.tassenabi.restapp.DataAccess.dataAccessConfigurations.DBConfig;

import javax.swing.*;
import java.io.File;

public class DataBaseSource {

        private static String DATABASEDRIVERNAME = "jdbc:sqlite:";
        private static File DATABASEPATH = new File("/Users/tassenabi/IdeaProjects/restfulApp/restapp/src/main/java/com/tassenabi/sources/database");
        private static String DATABASENAME = "user.db";
        private static File TESTDATABASEPATH= new File("/Users/tassenabi/IdeaProjects/restfulApp/restapp/src/main/java/com/tassenabi/sources/database");
        private static String TESTDATABASENAME = "userTestdatabase.db";

        public static String getDataBaseLink(){

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
