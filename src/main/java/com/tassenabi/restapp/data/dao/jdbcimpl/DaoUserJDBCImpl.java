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
import java.util.Optional;

import static com.tassenabi.restapp.data.querygenerator.jdbc.QueryJdbcGeneratorUser.COLUMN1;
import static com.tassenabi.restapp.data.querygenerator.jdbc.QueryJdbcGeneratorUser.COLUMN2;
import static com.tassenabi.restapp.data.config.util.ConverterStringForDataBase.*;

/**
 * DAO for the JDCB Database Fetch // CRUD-Methods
 */

public class DaoUserJDBCImpl implements IdaoEntity<User> {

    private ArrayList<User> allUsers;
    private UserForJDBC user;
    private Statement queryStatement;
    private ResultSet queryResult;
    private IDatabaseJdbcConnection connection;
    private boolean isLoggerActivated;

    //TODO Refactoring private Constructor
    public DaoUserJDBCImpl(){

    }

    //This constructor is for test database
    //TestDBConnection is the implementation for IDBConnection
    public DaoUserJDBCImpl(IDatabaseJdbcConnection connectToTestDatabase, boolean isLoggerActivated) {

        user = new UserForJDBC();
        allUsers = new ArrayList<User>();
        this.connection = connectToTestDatabase;
        this.isLoggerActivated = isLoggerActivated;

    }

    //TODO Refactoring try-with-resources
    @Override
    public List<User> getAll() {

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
    public void insert(User User){
        //Set firstLetter to upperCase and set last to lowerLetters
        String userName = formatUserNameForDatabase(User.getUserName());

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

    //TODO Refactoring try-with-resources
    @Override
    public void deleteUser(User user) {

        //Set firstLetter to upperCase and set last to lowerLetters
        String userName = formatUserNameForDatabase(user.getUserName());

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
    public void update(User oldUser, User newUser) {

        //Set firstLetter to upperCase and set last to lowerLetters
        String oldUserName = formatUserNameForDatabase(oldUser.getUserName());

        try {

            String queryCommand = QueryJdbcGeneratorUser.updateUserQuery(oldUser.getUserName(), newUser.getUserName());
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
    public Optional<User> get(User user) {
        //Set firstLetter to upperCase and set last to lowerLetters
        String userName = formatUserNameForDatabase(user.getUserName());

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

        return Optional.of(user);
    }

 
    //TODO Refactoring this methods belongs in a seperate class (SRP)
    private Connection openConnection()  {

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