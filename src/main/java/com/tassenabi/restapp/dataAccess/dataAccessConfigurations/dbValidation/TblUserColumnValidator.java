package com.tassenabi.restapp.dataAccess.dataAccessConfigurations.dbValidation;

import com.tassenabi.restapp.dataAccess.dataAccessConfigurations.dbConnection.DBConnection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import static com.tassenabi.restapp.dataAccess.queryGenerator.QueryJdbcGenerator.QueryJdbcGeneratorUser.*;

public class TblUserColumnValidator implements IDbColumnValidator {

    private Statement statement;
    private boolean tblColumnTitleOrderValidate = false;
    private DBConnection connection = new DBConnection();


    public TblUserColumnValidator() throws SQLException {

        tblColumnTitleOrderValidate = isColumnOrderValidate();

    }

    private boolean isColumnOrderValidate() throws SQLException {

        String query = "SELECT * FROM " + TABLENAME;
        statement = connection.getConnection().createStatement();
        ResultSet result = statement.executeQuery(query);

        ResultSetMetaData rsmd = result.getMetaData();

        String column1 = rsmd.getColumnName(1);
        System.out.println("In DB " + TABLENAME + " heißt Spalte 1: " + column1 + " im QueryGenerator: " + COLUMN1);

        String column2 = rsmd.getColumnName(2);
        System.out.println("In DB " + TABLENAME + " heißt Spalte 2: " + column2 + " im QueryGenerator: " + COLUMN2);

        return COLUMN1.equals(column1) && COLUMN2.equals(column2);

    }

    public boolean getIsColumnTitleOrderValidate() {

        return tblColumnTitleOrderValidate;
    }

    public int getCountRow() throws SQLException {

        String query = "SELECT Count(*) FROM " + TABLENAME;
        ResultSet result = statement.executeQuery(query);

        return result.getInt(1);
    }
}