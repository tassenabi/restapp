package com.tassenabi.databaseConfigurationTest.util;

import com.tassenabi.restapp.data.config.jdbcconfig.IDatabaseJdbcConnection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import static com.tassenabi.restapp.data.querygenerator.jdbc.QueryJdbcGeneratorUser.*;

public class DatabaseColumnValidator implements IDatabaseColumnValidator {

    private Statement statement;
    private boolean tblColumnTitleOrderValidate = false;
    private IDatabaseJdbcConnection connection;


    public DatabaseColumnValidator(IDatabaseJdbcConnection connection) throws SQLException {

        this.connection = connection;
        tblColumnTitleOrderValidate = isColumnOrderValidate();

    }

    private boolean isColumnOrderValidate() throws SQLException {

        String query = "SELECT * FROM " + TABLENAME;
        statement = connection.getDatabaseConnection().createStatement();
        ResultSet result = statement.executeQuery(query);

        ResultSetMetaData rsmd = result.getMetaData();

        String column1 = rsmd.getColumnName(1);
        System.out.println("In DB " + TABLENAME + " is Column 1: " + column1 + " in QueryGenerator: " + COLUMN1);

        String column2 = rsmd.getColumnName(2);
        System.out.println("In DB " + TABLENAME + " is Column 2: " + column2 + " in QueryGenerator: " + COLUMN2);

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