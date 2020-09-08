package com.tassenabi.restapp.data.config.jdbcconfig;

import com.tassenabi.restapp.data.config.databaseconfig.DataBaseSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseJdbcConnection implements IDatabaseJdbcConnection {

    private static String databaseClassNameDriver = DataBaseSource.getDatabaseClassNameDriver();
    private static String databaseSourcePath = DataBaseSource.getDataBaseUrl();
    private static DatabaseJdbcConnection instance;

    private static Connection connection;

    private DatabaseJdbcConnection(){
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

    public static DatabaseJdbcConnection getInstance() {

        if(instance == null){
            instance = new DatabaseJdbcConnection();
        }
        else {

            try {
                if(instance.getDatabaseConnection().isClosed()){
                    instance = new DatabaseJdbcConnection();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return instance;
    }
}