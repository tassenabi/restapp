package com.tassenabi.databaseConfigurationTest;

import com.tassenabi.databaseConfigurationTest.util.IDatabaseColumnValidator;
import com.tassenabi.databaseConfigurationTest.util.DatabaseColumnValidator;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class DatabaseColumnValidatorTest {

    @Test
    public void IsColumnOrderValidate_ShouldBeTrue() throws SQLException {

        IDatabaseColumnValidator isValidate = new DatabaseColumnValidator();
        boolean IsValidate = ((DatabaseColumnValidator) isValidate).getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }
}