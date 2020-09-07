package com.tassenabi.databaseConfigurationTest.util;

import com.tassenabi.restapp.data.config.jdbcconfig.DatabaseJdbcConnectionForTesting;
import com.tassenabi.restapp.data.config.jdbcconfig.IDatabaseJdbcConnection;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class ResetTestDataBase {

    private static IDatabaseJdbcConnection connection;
    private ResetTestDataBase() {

        throw new IllegalStateException("Instance of this Utilty Classes (ResetTestDataBase.class) are not allowed");

    }

    public static void executeDDLScript() throws SQLException {

        StringBuffer queryDDLCommands = new StringBuffer();
        connection = DatabaseJdbcConnectionForTesting.getInstance();

        File createScript = new File(getDDLScriptFilePath());

        try (BufferedReader reader = new BufferedReader(new FileReader(createScript))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                queryDDLCommands.append(line);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (Statement statement = connection.getDatabaseConnection().createStatement()) {
            statement.executeUpdate(String.valueOf(queryDDLCommands));

        }
        connection.getDatabaseConnection().close();

        JOptionPane.showMessageDialog(null,"The database was successfully reset");
    }

    private static String getDDLScriptFilePath() {

        String absPath = new File("").getAbsolutePath();
        return absPath + "//restapp//src//main//java//com//tassenabi//sources/database//CREATE_TABLE.sql";

    }
}