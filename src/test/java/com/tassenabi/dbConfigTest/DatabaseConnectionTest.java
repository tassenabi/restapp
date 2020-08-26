package com.tassenabi.dbConfigTest;

import com.tassenabi.restapp.dataAccess.dataAccessConfigurations.dbConnection.DBConnection;
import com.tassenabi.restapp.dataAccess.dataAccessConfigurations.dbConnection.IDBConnection;
import com.tassenabi.restapp.dataAccess.dataAccessConfigurations.dbConnection.TestDBConnection;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

public class DatabaseConnectionTest {

    @Test
    public void getConnection_ShouldBeNotNull() {

        //Arrange
        IDBConnection connection = new DBConnection();

        //Act
        Connection con = connection.getConnection();

        //Assert
        assertNotNull(con);
    }

    @Test
    public void getConnectionTestDatabase_ShouldBeNotNull() {

        //Arrange
        IDBConnection connection = new TestDBConnection();

        //Act
        Connection con = connection.getConnection();

        //Assert
        assertNotNull(con);
    }
}