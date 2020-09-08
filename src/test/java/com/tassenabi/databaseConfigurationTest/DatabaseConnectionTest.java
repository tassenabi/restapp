package com.tassenabi.databaseConfigurationTest;

import com.tassenabi.restapp.data.config.jdbcconfig.DatabaseJdbcConnection;
import com.tassenabi.restapp.data.config.jdbcconfig.DatabaseJdbcConnectionForTesting;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DatabaseConnectionTest {

    @Test
    public void getConnection_ShouldBeNotNull() {

        //Arrange // Act
        Connection con = DatabaseJdbcConnection.getInstance().getDatabaseConnection();

        //Assert
        assertNotNull(con);

    }

    @Test
    public void getConnection_ShouldBeReturnProductiveDatabase() throws SQLException {

        //Arrange
        Connection con = DatabaseJdbcConnection.getInstance().getDatabaseConnection();

        //Act
        String uriDatabase = con.getMetaData().getURL();
        boolean isProductiveDatabase = uriDatabase.contains("user.db");

        //Assert
        assertNotNull(con);
        assertThat(true, is(isProductiveDatabase));
    }

    @Test
    public void getConnectionTestDatabase_ShouldBeNotNull() {

        //Arrange //Act
        Connection con = DatabaseJdbcConnection.getInstance().getDatabaseConnection();

        //Assert
        assertNotNull(con);
    }

    @Test
    public void getConnection_ShouldBeReturnTestDatabase() throws SQLException {

        //Arrange

        //Act
        Connection con = DatabaseJdbcConnectionForTesting.getInstance().getDatabaseConnection();
        String uriDatabase = con.getMetaData().getURL();
        boolean isTestDatabase = uriDatabase.contains("userTestdatabase.db");

        //Assert
        assertNotNull(con);
        assertThat(true, is(isTestDatabase));

    }
}