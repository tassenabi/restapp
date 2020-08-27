package com.tassenabi.restapp.data.dao.jdbcimpl;

import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.entity.jdbcuser.UserForJDBC;
import com.tassenabi.restapp.data.dao.IdaoEntity;
import com.tassenabi.restapp.data.querygenerator.jdbc.QueryJdbcGeneratorUser;
import com.tassenabi.restapp.data.config.jdbcconfig.IDatabaseJdbcConnection;
import com.tassenabi.restapp.data.config.util.ApplicationLogger;
import com.tassenabi.restapp.exceptions.UserNotInDataBaseException;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.tassenabi.restapp.data.querygenerator.jdbc.QueryJdbcGeneratorUser.COLUMN1;
import static com.tassenabi.restapp.data.querygenerator.jdbc.QueryJdbcGeneratorUser.COLUMN2;
import static com.tassenabi.restapp.data.config.util.ConverterStringForDataBase.*;

/**
 * DAO for the JDCB Database Fetch // CRUD-Methods
 */

public class IdaoUserJDBCImpl implements IdaoEntity {

    private ArrayList<User> allUsers;
    private UserForJDBC user;
    private Statement queryStatement;
    private ResultSet queryResult;
    private IDatabaseJdbcConnection connection;
    private boolean isLoggerActivated;

    //TODO Refactoring private Constructor
    public IdaoUserJDBCImpl(){

    }

    //This constructor is for test database
    //TestDBConnection is the implementation for IDBConnection
    public IdaoUserJDBCImpl(IDatabaseJdbcConnection connectToTestDatabase, boolean isLoggerActivated) {

        user = new UserForJDBC();
        allUsers = new ArrayList<>();
        this.connection = connectToTestDatabase;
        this.isLoggerActivated = isLoggerActivated;

    }

    //TODO Refactoring try-with-resources
    @Override
    public List<User> getAllUser() {

        allUsers.clear();

        try {

            String queryCommand = QueryJdbcGeneratorUser.fetchQueryAllUser();
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allUsers.add(new UserForJDBC(queryResult.getInt(COLUMN1), queryResult.getString(COLUMN2)));

            }

            if(allUsers.isEmpty()){

                throw new UserNotInDataBaseException();

            }


        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();
            queryResult.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return allUsers;
    }

    //TODO Refactoring try-with-resources
    @Override
    public UserForJDBC getUser(String userName) {
        //Set firstLetter to upperCase and set last to lowerLetters
        userName = formatUserNameForDatabase(userName);

        try {
            String queryCommand = QueryJdbcGeneratorUser.fetchQueryOneUser(userName);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            if (queryResult.next()) {


                int id = queryResult.getInt(1);
                String userNameForObject = queryResult.getString(2);

                createUserObject(id, userNameForObject);

            } else {

                throw new UserNotInDataBaseException();

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();
            queryResult.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return user;
    }

    //TODO Refactoring try-with-resources
    @Override
    public void deleteUser(String userName) {

        //Set firstLetter to upperCase and set last to lowerLetters
        userName = formatUserNameForDatabase(userName);

        try {

            String queryCommand = QueryJdbcGeneratorUser.deleteQueryUser(userName);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            if (isLoggerActivated) {
                ApplicationLogger.loggingQueries(queryCommand);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    //TODO Refactoring try-with-resources
    @Override
    public void updateUser(String oldUserName, String newUserName) {

        //Set firstLetter to upperCase and set last to lowerLetters
        oldUserName = formatUserNameForDatabase(oldUserName);

        try {

            String queryCommand = QueryJdbcGeneratorUser.updateUserQuery(oldUserName, newUserName);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            if (isLoggerActivated) {
                ApplicationLogger.loggingQueries(queryCommand);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    //TODO Refactoring try-with-resources
    @Override
    public void insertUser(String userName){
        //Set firstLetter to upperCase and set last to lowerLetters
        userName = formatUserNameForDatabase(userName);

        try {

            String queryCommand = QueryJdbcGeneratorUser.insertUserQuery(userName);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            if (isLoggerActivated) {
                ApplicationLogger.loggingQueries(queryCommand);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    //TODO Refactoring this methods belongs in a seperate class (SRP)
    private Connection openConnection() throws SQLException {

        return connection.getDatabaseConnection();

    }

    //TODO Refactoring this methods belongs in a seperate class (SRP)
    private Statement createSQLStatement() throws SQLException {

        return this.openConnection().createStatement();

    }

    //TODO Refactoring this methods belongs in a seperate class (SRP)
    private void createUserObject(int id, String userName) {
        user.setId(id);
        user.setUserName(userName);
    }
}