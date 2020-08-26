package com.tassenabi.restapp.dataAccess.dataAccessConfigurations.dbValidation;

import java.sql.SQLException;

public interface IDbColumnValidator {

    boolean getIsColumnTitleOrderValidate() throws SQLException;

    int getCountRow() throws SQLException, ClassNotFoundException;

}


