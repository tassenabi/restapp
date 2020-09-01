package com.tassenabi.databaseConfigurationTest;

import com.tassenabi.restapp.data.config.jdbcconfig.DataBaseJDBCConnection;
import com.tassenabi.restapp.data.config.jdbcconfig.IDatabaseJdbcConnection;
import com.tassenabi.restapp.data.config.jdbcconfig.DatabaseJdbcConnectionForTesting;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

public class DatabaseConnectionTest {

    @Test
    public void getConnection_ShouldBeNotNull() {

        //Arrange
        IDatabaseJdbcConnection connection = new DataBaseJDBCConnection();

        //Act
        Connection con = connection.getDatabaseConnection();

        //Assert
        assertNotNull(con);

    }

    @Test
    public void getConnection_ShouldBeReturnProductiveDatabase() throws SQLException {

        //Arrange
        IDatabaseJdbcConnection connection = new DataBaseJDBCConnection();

        //Act
        Connection con = connection.getDatabaseConnection();
        String uriDatabase = con.getMetaData().getURL();
        boolean isProductiveDatabase = uriDatabase.contains("user.db");

        //Assert
        assertNotNull(con);
        assertThat(true, is(isProductiveDatabase));
    }

    @Test
    public void getConnectionTestDatabase_ShouldBeNotNull() {

        //Arrange
        IDatabaseJdbcConnection connection = new DatabaseJdbcConnectionForTesting();

        //Act
        Connection con = connection.getDatabaseConnection();

        //Assert
        assertNotNull(con);
    }

    @Test
    public void getConnection_ShouldBeReturnTestDatabase() throws SQLException {

        //Arrange
        IDatabaseJdbcConnection connection = new DatabaseJdbcConnectionForTesting();

        //Act
        Connection con = connection.getDatabaseConnection();
        String uriDatabase = con.getMetaData().getURL();
        boolean isTestDatabase = uriDatabase.contains("userTestdatabase.db");

        //Assert
        assertNotNull(con);
        assertThat(true, is(isTestDatabase));

    }
}