package com.tassenabi.restapp.DataAccess.dataAccessConfigurations.DBValidation;

import java.sql.SQLException;

public interface IDbColumnValidator {

    boolean getIsColumnTitleOrderValidate() throws SQLException;

    int getCountRow() throws SQLException, ClassNotFoundException;

}


