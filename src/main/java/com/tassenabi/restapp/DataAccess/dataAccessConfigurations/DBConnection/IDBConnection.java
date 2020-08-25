package com.tassenabi.restapp.DataAccess.dataAccessConfigurations.DBConnection;

import java.sql.Connection;

public interface IDBConnection {

    Connection connection = null;
    Connection getConnection();
    void closeConnection();
}
