package com.tassenabi.restapp.data.config.util;

import com.tassenabi.restapp.data.config.jdbcconfig.IDatabaseJdbcConnection;
import com.tassenabi.restapp.data.config.jdbcconfig.DatabaseJdbcConnectionForTesting;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class ResetTestDataBase {

    private static Statement statement;
    private static StringBuffer queryDDLCommands;
    private static IDatabaseJdbcConnection connection;

    private ResetTestDataBase() {

        throw new IllegalStateException("Instance of this Utilty Classes (ResetTestDataBase.class) are not allowed");

    }

    public static void executeDDLScript() throws IOException, SQLException {

        queryDDLCommands = new StringBuffer();
        connection = new DatabaseJdbcConnectionForTesting();

        File createScript = new File(getDDLScriptFilePath());

        BufferedReader reader = new BufferedReader(new FileReader(createScript));

        try {
            String line = null;
            while ((line = reader.readLine()) != null) {
                queryDDLCommands.append(line);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally
        {
            reader.close();
        }

        statement = connection.getDatabaseConnection().createStatement();
        statement.executeUpdate(String.valueOf(queryDDLCommands));
        statement.close();
        connection.closeDatabaseConnection();

        JOptionPane.showMessageDialog(null,"The database was successfully reset");
    }

    private static String getDDLScriptFilePath() {

        String absPath = new File("").getAbsolutePath();
        return absPath + "//restapp//src//main//java//com//tassenabi//sources/database//CREATE_TABLE.sql";

    }
}