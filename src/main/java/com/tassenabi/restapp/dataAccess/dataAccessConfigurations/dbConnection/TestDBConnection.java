package com.tassenabi.restapp.dataAccess.dataAccessConfigurations.dbConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDBConnection implements IDBConnection {

    public Connection getConnection() {

        return new ConnectionFactory().createTestDataBaseConnection();
    }

    public  void closeConnection() {

        try {
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
