package com.tassenabi.restapp.data.config.jdbcconfig;

import com.tassenabi.restapp.data.config.databaseconfig.DataBaseSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseJDBCConnection implements IDatabaseJdbcConnection {

    private String databaseSourcePath = DataBaseSource.getDataBaseLink();

    public Connection getDatabaseConnection() {

        return new DatabaseJDBCConnectionFactory().createDatabaseConnection(databaseSourcePath);

    }

    public  void closeDatabaseConnection() {

        try {
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}