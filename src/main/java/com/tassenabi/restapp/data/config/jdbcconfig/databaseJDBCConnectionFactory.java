package com.tassenabi.restapp.data.config.jdbcconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseJDBCConnectionFactory {

    private Connection databaseConnection;

    public Connection createDatabaseConnection(String databaseSourcePath){

        try {
            Class.forName("org.sqlite.JDBC");
            databaseConnection = DriverManager.getConnection(databaseSourcePath);

            //Activate Foreign-Key Support on each call (not supported by SQLite ... if you change DBMS, you have to delete this)
            //The createStatement just send this information; therefore not an QueryStatement
            databaseConnection.createStatement().execute("PRAGMA foreign_keys = ON");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }

        return databaseConnection;
    }
}