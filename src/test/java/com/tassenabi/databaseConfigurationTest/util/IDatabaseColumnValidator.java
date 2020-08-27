package com.tassenabi.databaseConfigurationTest.util;

import java.sql.SQLException;

/**
 * The interface is for the case that there will be more then one table
 */

public interface IDatabaseColumnValidator {

    boolean getIsColumnTitleOrderValidate() throws SQLException;

    int getCountRow() throws SQLException, ClassNotFoundException;

}


