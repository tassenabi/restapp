package com.tassenabi.DBConfigTest;

import com.tassenabi.restapp.DataAccess.dataAccessConfigurations.DBValidation.IDbColumnValidator;
import com.tassenabi.restapp.DataAccess.dataAccessConfigurations.DBValidation.TblUserColumnValidator;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class TblUserColumnValidateTest {

    @Test
    public void testIsColumnOrderValidate_TblGuest() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblUserColumnValidator();
        boolean IsValidate = ((TblUserColumnValidator) isValidate).getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }
}