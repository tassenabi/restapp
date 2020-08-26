package com.tassenabi.restapp.dataAccess.dataAccessConfigurations.dbConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection implements IDBConnection{

    public Connection getConnection() {

        return new ConnectionFactory().createConnection();

    }

    public  void closeConnection() {

        try {
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
