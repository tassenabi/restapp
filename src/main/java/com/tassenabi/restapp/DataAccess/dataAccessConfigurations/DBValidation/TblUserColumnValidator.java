package com.tassenabi.restapp.DataAccess.dataAccessConfigurations.DBValidation;

import com.tassenabi.restapp.DataAccess.dataAccessConfigurations.DBConnection.DBConnection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import static com.tassenabi.restapp.DataAccess.QueryGenerator.QueryGeneratorUser.*;

public class TblUserColumnValidator implements IDbColumnValidator {

    private Statement statement;
    private boolean TblColumnTitleOrderValidate = false;
    private DBConnection connection = new DBConnection();


    public TblUserColumnValidator() throws SQLException {

        TblColumnTitleOrderValidate = isColumnOrderValidate();

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

        return TblColumnTitleOrderValidate;
    }

    public int getCountRow() throws SQLException {
        String query = "SELECT Count(*) FROM " + TABLENAME;
        ResultSet result = statement.executeQuery(query);
        int count = result.getInt(1);
        return count;
    }
}