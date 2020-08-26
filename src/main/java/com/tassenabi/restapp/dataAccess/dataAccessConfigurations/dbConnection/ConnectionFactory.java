package com.tassenabi.restapp.dataAccess.dataAccessConfigurations.dbConnection;

import com.tassenabi.restapp.dataAccess.dataAccessConfigurations.dbConfig.DataBaseSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private Connection connection;

    public Connection createConnection(){

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DataBaseSource.getDataBaseLink());

            //Activate Foreign-Key Support on each call (not supported by SQLite ... if you change DBMS, you have to delete this)
            //The createStatement just send this information; therefore not an QueryStatement
            connection.createStatement().execute("PRAGMA foreign_keys = ON");

        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();

        }

        return connection;
    }

    public Connection createTestDataBaseConnection(){

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DataBaseSource.getTestDataBaseLink());

            //Activate Foreign-Key Support on each call (not supported by SQLite ... if you change DBMS, you have to delete this)
            //The createStatement just send this information; therefore not an QueryStatement
            connection.createStatement().execute("PRAGMA foreign_keys = ON");

        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
