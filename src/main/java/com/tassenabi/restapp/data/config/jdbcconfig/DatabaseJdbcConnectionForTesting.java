package com.tassenabi.restapp.data.config.jdbcconfig;

import com.tassenabi.restapp.data.config.databaseconfig.DataBaseSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseJdbcConnectionForTesting implements IDatabaseJdbcConnection {

    private static String databaseClassNameDriver = DataBaseSource.getDatabaseClassNameDriver();
    private static String databaseSourcePath = DataBaseSource.getTestDataBaseUrl();
    private static DatabaseJdbcConnectionForTesting instance;

    private static Connection connection;

    private DatabaseJdbcConnectionForTesting(){
        try {
            //TODO Refactor --> Class.ForName dynamic laoding
            Class.forName(databaseClassNameDriver);
            connection = DriverManager.getConnection(databaseSourcePath);

            //Activate Foreign-Key Support on each call (not supported by SQLite ... if you change DBMS, you have to delete this)
            //The createStatement just send this information; therefore not an QueryStatement
            connection.createStatement().execute("PRAGMA foreign_keys = ON");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
    }
    public Connection getDatabaseConnection(){

        return connection;
    }

    public static DatabaseJdbcConnectionForTesting getInstance() {

        if(instance == null){
            instance = new DatabaseJdbcConnectionForTesting();
        }
        else {

            try {
                if(instance.getDatabaseConnection().isClosed()){
                    instance = new DatabaseJdbcConnectionForTesting();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

        return instance;
    }
}