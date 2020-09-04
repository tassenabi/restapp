package com.tassenabi.restapp.data.dao.jdbcimpl;

import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.entity.jdbcuser.UserForJDBC;
import com.tassenabi.restapp.data.dao.IdaoEntity;
import com.tassenabi.restapp.data.querygenerator.jdbc.QueryJdbcGeneratorUser;
import com.tassenabi.restapp.data.config.jdbcconfig.IDatabaseJdbcConnection;
import com.tassenabi.restapp.data.config.util.ApplicationLogger;
import com.tassenabi.restapp.exceptions.UserNotInDataBaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
    private PreparedStatement queryStatement;
    private ResultSet queryResult;
    private IDatabaseJdbcConnection connection;
    private boolean isLoggerActivated;

    private DaoUserJDBCImpl(){

    }

    //This constructor is for test database
    //TestDBConnection is the implementation for IDBConnection
    public DaoUserJDBCImpl(IDatabaseJdbcConnection connectToTestDatabase, boolean isLoggerActivated) {

        user = new UserForJDBC();
        allUsers = new ArrayList<>();
        this.connection = connectToTestDatabase;
        this.isLoggerActivated = isLoggerActivated;

    }

    @Override
    public List<User> getAll() {

        allUsers.clear();

        try {

            String queryCommand = QueryJdbcGeneratorUser.fetchQueryAllUser();
            queryStatement = prepareStatement(queryCommand);
            queryResult = queryStatement.executeQuery();

            while (queryResult.next()) {

                allUsers.add(new UserForJDBC(queryResult.getInt(COLUMN1), queryResult.getString(COLUMN2)));

            }

            if(allUsers.isEmpty()){

                throw new UserNotInDataBaseException("Error: No User in Database");

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

    @Override
    public void insert(User user){
        //Set firstLetter to upperCase and set last to lowerLetters
        String userName = formatUserNameForDatabase(user.getUserName());

        try {

            String queryCommand = QueryJdbcGeneratorUser.insertUserQuery();
            queryStatement = prepareStatement(queryCommand);
            queryStatement.setString(2,userName);
            queryStatement.executeUpdate();

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

    @Override
    public void deleteUser(User user) {

        //Set firstLetter to upperCase and set last to lowerLetters
        String userName = formatUserNameForDatabase(user.getUserName());

        try {

            String queryCommand = QueryJdbcGeneratorUser.deleteQueryUser();
            queryStatement = prepareStatement(queryCommand);
            queryStatement.setString(1, userName);
            queryStatement.executeUpdate();

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

    @Override
    public void update(User oldUser, User newUser) {

        //Set firstLetter to upperCase and set last to lowerLetters
        String previousUserName = formatUserNameForDatabase(oldUser.getUserName());
        String newUserName = formatUserNameForDatabase(newUser.getUserName());

        try {

            String queryCommand = QueryJdbcGeneratorUser.updateUserQuery();
            queryStatement = prepareStatement(queryCommand);
            queryStatement.setString(1,newUserName);
            queryStatement.setString(2,previousUserName);
            queryStatement.executeUpdate();

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

    @Override
    public Optional<User> get(User user) {
        //Set firstLetter to upperCase and set last to lowerLetters
        String userName = formatUserNameForDatabase(user.getUserName());

        try {
            String queryCommand = QueryJdbcGeneratorUser.fetchQueryOneUser();
            queryStatement = prepareStatement(queryCommand);
            queryStatement.setString(1,userName);
            queryResult = queryStatement.executeQuery();

            if (queryResult.next()) {


                int id = queryResult.getInt(1);
                String userNameForObject = queryResult.getString(2);

                createUserObject(id, userNameForObject);

            } else {

                throw new UserNotInDataBaseException("Error: No User in Database");

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
    private PreparedStatement prepareStatement(String query) throws SQLException {

        return this.openConnection().prepareStatement(query);

    }

    //TODO Refactoring this methods belongs in a seperate class (SRP)
    private void createUserObject(int id, String userName) {
        user.setId(id);
        user.setUserName(userName);
    }
}