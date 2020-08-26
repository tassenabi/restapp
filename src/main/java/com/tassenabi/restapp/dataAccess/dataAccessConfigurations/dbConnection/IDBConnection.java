package com.tassenabi.restapp.dataAccess.dataAccessConfigurations.dbConnection;

import java.sql.Connection;

public interface IDBConnection {

    Connection connection = null;
    Connection getConnection();
    void closeConnection();
}
