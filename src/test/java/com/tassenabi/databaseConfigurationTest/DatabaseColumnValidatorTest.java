package com.tassenabi.databaseConfigurationTest;

import com.tassenabi.databaseConfigurationTest.util.IDatabaseColumnValidator;
import com.tassenabi.databaseConfigurationTest.util.DatabaseColumnValidator;
import com.tassenabi.restapp.data.config.jdbcconfig.DataBaseJDBCConnection;
import com.tassenabi.restapp.data.config.jdbcconfig.DatabaseJdbcConnectionForTesting;
import com.tassenabi.restapp.data.config.jdbcconfig.IDatabaseJdbcConnection;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class DatabaseColumnValidatorTest {

    private IDatabaseJdbcConnection productiveDatabaseConnection;
    private IDatabaseJdbcConnection testDatabaseConnection;

    @Test
    public void IsColumnOrderValidateProductiveDataBase_ShouldBeTrue() throws SQLException {

        productiveDatabaseConnection = new DataBaseJDBCConnection();
        IDatabaseColumnValidator isValidate = new DatabaseColumnValidator(productiveDatabaseConnection);
        boolean IsValidate = ((DatabaseColumnValidator) isValidate).getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }

    @Test
    public void IsColumnOrderValidateTestDataBase_ShouldBeTrue() throws SQLException {

        testDatabaseConnection = new DatabaseJdbcConnectionForTesting();
        IDatabaseColumnValidator isValidate = new DatabaseColumnValidator(testDatabaseConnection);
        boolean IsValidate = ((DatabaseColumnValidator) isValidate).getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }
}